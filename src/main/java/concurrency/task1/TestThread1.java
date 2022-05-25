package concurrency.task1;

public class TestThread1 extends Thread {

    private final Object lock;

    public TestThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                Thread.sleep(2000);
                lock.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
