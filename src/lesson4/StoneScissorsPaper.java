package lesson4;

import java.util.LinkedList;

public class StoneScissorsPaper {

    Runnable stone, paper, scissors;
    void go(){
        Object lock = new Object();
        stone = ()->{
            synchronized (lock){
                while (true){
                    System.out.print("Камень ");
                    try {
                        Thread.sleep(1000);
                        lock.notifyAll();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        scissors = ()->{
            synchronized (lock){
                while (true){
                    System.out.print("Ножницы ");
                    try {
                        Thread.sleep(1000);
                        lock.notifyAll();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        paper = ()->{
            synchronized (lock){
                while (true){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Бумага ");
                    try {
                        Thread.sleep(1000);
                        lock.notifyAll();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(stone).start();
        new Thread(scissors).start();
        new Thread(paper).start();
    }

    public static void main(String[] args) {
        new StoneScissorsPaper().go();
    }
}
