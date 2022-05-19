package concurrency.task3;

public class Task3Runner {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MessageThread());
        Thread thread2 = new Thread(new TimeThread());

        thread1.start();
        thread2.start();
    }

}
