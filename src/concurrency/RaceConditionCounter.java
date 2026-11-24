package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Counter {
    private int counter;

    public Counter() {
        this.counter = 0;
    }

    public synchronized void increament() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }
}

public class RaceConditionCounter {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter = new Counter();
        Callable<Integer> task1 = () -> {
            for (int i = 0; i < 100000; i++) {
                counter.increament();
            }
            return counter.getCounter();
        };

        Callable<Integer> task2 = () -> {
            for (int i = 0; i < 100000; i++) {
                counter.increament();
            }
            return counter.getCounter();
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<Integer> fut1 = executor.submit(task1);
            Future<Integer> fut2 = executor.submit(task2);

            Integer res1 = fut1.get();
            Integer res2 = fut2.get();

            System.out.println(res1);
            System.out.println(res2);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            executor.shutdown();
        }

    }
}
