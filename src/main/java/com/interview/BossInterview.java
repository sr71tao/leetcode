package com.interview;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * 返回最快方法的结果
 * Created by yuntao.wu on 2021/12/12.
 */
public class BossInterview {
    private static ExecutorService executor = Executors.newFixedThreadPool(3);
    private static AtomicReference<String> reference = new AtomicReference<>();

    public static void main(String[] args) {
        BossInterview interview = new BossInterview();
        System.out.println(interview.translate("hello world"));
        executor.shutdown();
    }

    public String translate(String content) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        executor.submit(new MyRunnable(this::baidu, content, lock, condition));
        executor.submit(new MyRunnable(this::google, content, lock, condition));
        executor.submit(new MyRunnable(this::youdao, content, lock, condition));
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(reference.get()).orElse("null");
    }

    public String baidu(String content) {
        randomSleep();
        return "baidu:" + content;
    }
    public String google(String content) {
        randomSleep();
        return "google:" + content;
    }
    public String youdao(String content) {
        randomSleep();
        return "youdao:" + content;
    }

    private void randomSleep() {
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyRunnable implements Runnable {
        private Function<String, String> func;
        private String params;
        private Lock lock;
        private Condition condition;

        public MyRunnable(Function<String, String> func, String params, Lock lock, Condition condition) {
            this.func = func;
            this.params = params;
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            try {
                String result = func.apply(params);
                System.out.println(Thread.currentThread().getName() + "---" + result);
                if (reference.get() != null) {
                    return;
                }
                lock.lock();
                if (reference.get() == null) {
                    reference.set(result);
                }
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }
}
