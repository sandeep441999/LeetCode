package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long startTime = System.currentTimeMillis();

        Callable<Integer> task1 = () -> {
            Thread.sleep(1000);
            return 10 + 20;
        };
        Callable<Integer> task2 = () -> {
            Thread.sleep(2000);
            return 5 * 10;
        };
        Callable<Integer> task3 = () -> {
            Thread.sleep(3000);
            return 100 - 40;
        };

        ExecutorService executors = Executors.newFixedThreadPool(3);

        Future<Integer> future1 = executors.submit(task1);
        Future<Integer> future2 = executors.submit(task2);
        Future<Integer> future3 = executors.submit(task3);

        Integer res1 = future1.get();
        Integer res2 = future2.get();
        Integer res3 = future3.get();

        System.out.println(res1 + res2 + res3);
        executors.shutdown();
        long endTime = System.currentTimeMillis();

        System.out.println("Total time to complete all 3 callables is : " + (endTime - startTime));

    }
}
