package concurrency.task1;

public class TestThread2 extends Thread {

    private final Object lock;

    public TestThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                Thread.sleep(500);
                lock.notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
