package classwork.jan2020;

public class StressTest {
    public static void main(String[] args) {
        RequestPerSecond rps = new RequestPerSecond(500);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    rps.allow();
                }
            }).start();
        }
    }
}
