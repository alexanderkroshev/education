package concurrency.task2;

class TestThread extends Thread {
    private final Object lock;

    public TestThread(String name, Object object) {
        super(name);
        this.lock = object;
    }

    @Override
    public void run() {
        int i = 0;
        synchronized (lock) {
            while (i < 5) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    lock.notify();
                    lock.wait();
                    i++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lock.notify();
        }
    }
}
