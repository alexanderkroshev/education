package concurrency.task3;

public class Task3Runner {
    public static void main(String[] args) {
        Object lock = new Object();
        Worker worker = new Worker(lock);
        Thread clockThread = new Thread(new ChronometerThread(worker));
        Thread messageThread = new Thread(new MessageThread(worker));
        clockThread.start();
        messageThread.start();
    }
}

