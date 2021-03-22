package geektime.algo.leecode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 21:41
 * @description:
 */
public class SerialThread {

    private static Lock lock = new ReentrantLock();
    private static  int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int counter = 0; counter < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {
                        System.out.print("A");
                        state++;
                        counter++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int counter = 0; counter < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                        counter++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int counter = 0; counter < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.print("C");
                        state++;
                        counter++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadA treadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();

        treadA.start();
        threadB.start();
        threadC.start();
    }
}