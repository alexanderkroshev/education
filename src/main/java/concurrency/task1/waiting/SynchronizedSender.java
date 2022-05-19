package concurrency.task1.waiting;



public class SynchronizedSender implements Runnable {
    private final Data data;

    public SynchronizedSender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            data.send("test");
            data.notifyAll();
        }
    }
}