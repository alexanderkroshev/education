package concurrency.task1.waiting;

public class SynchronizedReceiver implements Runnable {
    private final Data data;
    private String message;

    public SynchronizedReceiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            try {
                data.wait();
                this.message = data.receive();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}