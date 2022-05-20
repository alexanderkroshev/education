package concurrency.task3;

public class Task3Runner {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MessageThread());
        Thread thread2 = new Thread(new TimeThread());
        Thread thread3 = new Thread(new AnotherMessageThread());

        thread1.start();
        thread2.start();
        thread3.start();

    }

}
