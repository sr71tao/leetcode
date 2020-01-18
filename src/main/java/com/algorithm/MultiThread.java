package com.algorithm;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuntao.wu on 2019/12/1.
 * 多线程轮流打印ABC
 */
public class MultiThread {

    public static final int MAX_TIME = 10;
    public static int state = 0;
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        /**
         * 使用lock / synchronized
         */
        /*MyThread thread1 = new MyThread("thread1", 0, "A");
        MyThread thread2 = new MyThread("thread2", 1, "B");
        MyThread thread3 = new MyThread("thread3", 2, "C");

        thread1.start();
        thread2.start();
        thread3.start();*/

        /**
         * 使用semaphore
         */
       /* Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        SempThread threadA = new SempThread("threadA", 0, semaphoreA, semaphoreB);
        SempThread threadB = new SempThread("threadB", 1, semaphoreB, semaphoreC);
        SempThread threadC = new SempThread("threadC", 2, semaphoreC, semaphoreA);

        threadA.start();
        threadB.start();
        threadC.start();*/


        /**
         * 使用condition
         */
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        CondThread condThreadA = new CondThread("threadA", 0, conditionA, conditionB);
        CondThread condThreadB = new CondThread("threadB", 1, conditionB, conditionC);
        CondThread condThreadC = new CondThread("threadC", 2, conditionC, conditionA);

        condThreadA.start();
        condThreadB.start();
        condThreadC.start();

    }

    static class MyThread extends Thread {

        private int val;
        private String str;

        public MyThread(String tName, int val, String result) {
            super(tName);
            this.val = val;
            str = result;
        }

        public void run() {
            for (int i = 0; i < MAX_TIME; ) {
                try {
                    lock.lock();
                    if (state % 3 == val) {
                        System.out.println(Thread.currentThread().getName() + " -- " + str);
                        ++state;
                        i++;
                    }
                } finally {
                    lock.unlock();
                    //System.out.println(Thread.currentThread().getName() + "解锁");
                }
            }
            //System.out.println(Thread.currentThread().getName()  + " end");
        }
    }


    static class SempThread extends Thread {
        private Semaphore curSemaphore;
        private Semaphore nxtSemaphore;
        private int val;

        public SempThread(String tName, int val, Semaphore cur, Semaphore nxt) {
            super(tName);
            this.val = val;
            curSemaphore = cur;
            nxtSemaphore = nxt;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_TIME; i++) {
                try {
                    curSemaphore.acquire();
                    System.out.println(currentThread().getName() + " -- " + (char) ('A' + val));
                    nxtSemaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    static class CondThread extends Thread {
        private int val;
        private Condition curCond;
        private Condition nxtCond;

        public CondThread(String tName, int val, Condition curCond, Condition nxtCond) {
            super(tName);
            this.val = val;
            this.curCond = curCond;
            this.nxtCond = nxtCond;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_TIME; i++) {
                try {
                    lock.lock();
                    while (state % 3 != val) {
                        curCond.await();
                    }
                    ++state;
                    System.out.println(currentThread().getName() + " -- " + (char) ('A' + val));
                    nxtCond.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }


    }
}


