package concurrency.task1;

public class Task1Runner {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        TestThread1 thread2 = new TestThread1(lock);
        TestThread2 thread3 = new TestThread2(lock);
        System.out.println("create thread: " + thread2.getState());
        thread2.start();
        thread3.start();
        System.out.println("thread is running: " + thread3.getState());
        Thread.sleep(100);
        System.out.println("thread is waiting(millis): " + thread2.getState());
        System.out.println("thread is blocked: " + thread3.getState());
        Thread.sleep(1200);
        System.out.println("state after wait(): " + thread2.getState());
        Thread.sleep(500);
        System.out.println("finish run: " + thread3.getState());
    }
}
