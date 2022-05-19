package concurrency.task2;

public class Task2Runner {
    public static void main(String[] args)  {
        Object lock = new Object();
        Thread thread1 = new TestThread("thread 1", lock);
        Thread thread2 = new TestThread("thread 2", lock);

        thread1.start();
        thread2.start();
        }
    }

