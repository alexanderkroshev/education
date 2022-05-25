package concurrency.task3;


public class Timer extends Thread {
    private volatile static int count = 0;
    private Object lock;

    public Timer(Object lock) {
        this.lock = lock;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                synchronized (lock) {
                    count++;
                    System.out.println(count);
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

