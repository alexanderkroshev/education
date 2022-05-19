package concurrency.task2;

import lombok.ToString;

@ToString
class TestThread extends Thread {

      private final Object lock;

    public TestThread(String name, Object object) {
        super(name);
        this.lock = object;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(500);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}