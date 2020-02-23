package lesson4;

public class PingPong {

    Runnable ping, pong;

    void go() {
        Object lock = new Object();

        ping = () -> {
            synchronized (lock) {
                while (true) {
                    System.out.print("PING ");
                    try {
                        Thread.sleep(1000);
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        pong = () -> {
            synchronized (lock) {
                while (true) {
                    System.out.println("PONG ");
                    try {
                        Thread.sleep(1000);
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(ping).start();
        new Thread(pong).start();
    }

    public static void main(String[] args) {
        new PingPong().go();
    }
}
