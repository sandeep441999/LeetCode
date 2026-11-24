package concurrency;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            for (int i = 1; i < 6; i++) {
                System.out.println(i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 65; i < 70; i++) {
                System.out.println((char) i);
            }
        };
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("All tasks completed");
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());
    }
}
