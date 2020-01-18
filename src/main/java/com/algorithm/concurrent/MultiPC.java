package com.algorithm.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by yuntao.wu on 2019/12/1.
 * 生产者消费者
 */
public class MultiPC {

    private static volatile boolean isRun = true;

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new SynchronousQueue<>());
        executor.submit(consumer);
        executor.submit(producer);
        executor.submit(producer);
        executor.submit(producer);


        try {
            Thread.sleep(7 * 1000L);
            isRun = false;
            Thread.sleep(3 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }


    static class  Consumer implements Runnable {

        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 【开始消费】");
            while(true) {
                Integer val = null;
                try {

                    val = queue.poll(50, TimeUnit.MILLISECONDS);
                    if (val == null) {
                        if (!isRun) {
                            System.out.println(Thread.currentThread().getName() + " 【结束消费】");
                            break;
                        }
                        continue;
                    }
                    System.out.println(Thread.currentThread().getName() + "【消费】 " + val);
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Producer implements Runnable {

        private BlockingQueue<Integer> queue;

        private Random random = new Random();

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 【开始生产】" );
            while(isRun) {
                int val = random.nextInt();
                try {
                    boolean flag = queue.offer(val,30, TimeUnit.MILLISECONDS);
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + " 【生产阻塞】 " + queue.size());
                    }
                    if (!isRun) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " 【生产】 " + val);
                    Thread.sleep(150L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " 【结束生产】" );
        }
    }
}


