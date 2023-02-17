package task4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) {
        single();
//        multi(3);
    }

    private static void multi(int count) {
        MyService executorService = new MyService(count);
        executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executorService.submit(() -> System.out.println("Start"));
        executorService.shutdown();
    }

    private static void single() {
        MyService executorService = new MyService(1);
        executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executorService.submit(() -> System.out.println("Start"));
        executorService.shutdown();
    }
}
