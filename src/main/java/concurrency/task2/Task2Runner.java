package concurrency.task2;

public class Task2Runner {
    public static void main(String[] args) {
        Object lock = new Object();
        new TestThread("thread 1", lock).start();
        new TestThread("thread 2", lock).start();
    }
}

