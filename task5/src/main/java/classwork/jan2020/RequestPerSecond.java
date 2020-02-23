package classwork.jan2020;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;

public class RequestPerSecond {

    private ConcurrentLinkedDeque<AtomicLong> summary;
    private Thread backGround;
    private int limit;

    public RequestPerSecond(int limit) {
        this.limit = limit;
        summary = new ConcurrentLinkedDeque();
        backGround = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                summary.addLast(new AtomicLong(0));
            }
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                summary.addLast(new AtomicLong(0));
                summary.removeFirst();
            }
        });
        backGround.start();
    }

    public boolean allow() {
        summary.getLast().incrementAndGet();
        long val = 0;
        for (AtomicLong lo : summary) {
            val += lo.get();
        }
        if(val > limit) System.out.println(val);
        return val < limit;
    }
}
