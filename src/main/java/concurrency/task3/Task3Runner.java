package concurrency.task3;

public class Task3Runner {
    public static void main(String[] args) {
        Object lock = new Object();
        new Timer(lock).start();
        new MessageThread(5, "message1!", lock).start();
        new MessageThread(7, "message2!", lock).start();
    }
}
