package concurrency.task1;

public class TestThread extends Thread {
  final Counter counter;

    public TestThread(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }
    @Override
    public void run() {
        try {
            synchronized (counter) {
                Thread.sleep(1000);
                counter.increment();
            }
             } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
