package concurrency.task2;

import lombok.SneakyThrows;

class TestThread extends Thread {

      private final Object lock;

    public TestThread(String name, Object object) {
        super(name);
        this.lock = object;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                    System.out.println(Thread.currentThread().getName());
                    //Thread.sleep(500);
                    lock.notify();
                    lock.wait();
            }
        }
    }
}