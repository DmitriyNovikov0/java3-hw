package classwork.jan2020;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SyncPrimitives {

    static volatile int inc = 0;

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
//        for (int i = 0; i < 4; i++) {
//            final int finalI = i;
//            new Thread(() -> {
//                try {
//                    sem.acquire();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                while (true) {
//                    System.out.print(finalI + " ");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    sem.release();
//                }
//            }).start();
//        }
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                while (true) {
                    lock.lock();
                    inc++;
                    System.out.println(Thread.currentThread().getName() + " doing little work");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (inc > 10) {
                        lock.unlock();
                        System.out.println(Thread.currentThread().getName() +
                                " start hard work");
                        inc = 0;
                        for (int j = 0; j < 1000000000; j++) {
                            for (int k = 0; k < 10; k++) {

                            }
                        }
                        System.out.println(Thread.currentThread().getName() +
                                " finish hard work");

                    } else {
                        lock.unlock();
                    }
                }
            }).start();

        }
    }
}
