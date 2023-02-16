package task3;

import java.util.*;

public class Test {
    private static Map<Integer, String> mapSync = new MapSemaphore<>();

    private static Set<Integer> setSync = new SetLock();
//    private static Set<Integer> setSync = new HashSet<>();


    public static void main(String[] args) {
//        testMap(mapSync);
        testSet(setSync);
    }

    private static void testMap(Map<Integer, String> mapSync) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 21; i++) {
                mapSync.put(i, "value" + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 21; i < 41; i++) {
                mapSync.put(i, "value" + i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sync list:");
        mapSync.forEach((key, value) -> System.out.println(key + ": " + value));
    }


    private static void testSet(Set<Integer> setSync){

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 21; i++) {
                setSync.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 21; i < 41; i++) {
                setSync.add(i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sync list:");
        setSync.forEach(System.out::println);
    }
}
