package lesson4;

import java.io.ObjectInputStream;

public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock){
                System.out.println("Doing task");
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        synchronized (lock){
            System.out.println("Wait 5 seconds!");
            for (int i = 1; i < 6; i++) {
                System.out.println(i + " sec");
                Thread.sleep(1000);
            }
            System.out.println("Task starts now");
            Thread.sleep(1500);
        }

    }
}
