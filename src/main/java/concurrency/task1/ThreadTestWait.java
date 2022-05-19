package concurrency.task1;

public class ThreadTestWait extends Thread{

    private Object lock;

    public ThreadTestWait(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
