package com.interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.function.Consumer;

/**
 * Created by wuyuntao on 2021/12/23
 */
public class CoupangInterview3 {

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(1, 1000);
        scheduler.submit(new Task(System.currentTimeMillis() + 1000, (r) -> System.out.println("run"), null));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.setStop();
    }

    public static class Scheduler {
        private static volatile boolean stop;
        private int mod; // 0-fixed Time, 1-recur
        private Thread thread;
        private BlockingQueue<Task> taskList;
        private long period;

        public Scheduler(int mod, long period) {
            this.mod = mod;
            if (mod == 1) {
                this.period = period;
            }
            this.thread = new Thread(new ThreadRunnable());
            this.taskList = new PriorityBlockingQueue<>();
            this.thread.start();
        }

        public void submit(Task task) {
            taskList.add(task);
        }

        public void setStop() {
            stop = true;
        }

        public class ThreadRunnable implements Runnable {

            @Override
            public void run() {
                while (!stop) {
                    Task task = taskList.peek();
                    if (task == null) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // error log
                        }
                        continue;
                    }
                    long now = System.currentTimeMillis();
                    if (now < task.getTimeStamp()) {
                        try {
                            Thread.sleep(task.getTimeStamp() - now);
                        } catch (InterruptedException e) {
                           // error log
                        }
                    }
                    task = taskList.poll();
                    task.run();
                    if (mod == 1) {
                        taskList.add(new Task(now + period, task.consumer, task.param));
                    }
                }
            }
        }

    }

    public static class Task implements Comparable {
        private long timeStamp;
        private Consumer consumer;
        private Object param;

        public Task(long timeStamp, Consumer consumer) {
            this.timeStamp = timeStamp;
            this.consumer = consumer;
        }

        public Task(long timeStamp, Consumer consumer, Object param) {
            this.timeStamp = timeStamp;
            this.consumer = consumer;
            this.param = param;
        }

        public void run() {
            consumer.accept(param);
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Task) {
                return this.getTimeStamp() >= 0 ? 1 : -1;
            }
            return -1;
        }
    }
}
