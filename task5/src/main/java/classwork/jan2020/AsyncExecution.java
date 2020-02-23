package classwork.jan2020;

import javax.sound.midi.ControllerEventListener;
import java.util.concurrent.*;

public class AsyncExecution {

    @FunctionalInterface
    interface Lam<T> {
        T ok(int a, int b);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        //web service ________________
        //fabric.getInstance();
        Runnable runner = () -> System.out.println("LOL");
        Lam<String> link = (x, y) -> "null";
        System.out.println(runner.getClass());
        Callable<String> caller = () -> {
            for (int i = 0; i < 2000000000; i++) {
                for (int j = 0; j < 10; j++) {
                    
                }
            }
            return "SUCCESS";
        };
        executor.execute(runner);
        Future<String> future = executor.submit(caller);
        System.out.print("Calculating");
        while (!future.isDone()) {
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println("\n" + future.get());
        executor.shutdown();
    }
}
