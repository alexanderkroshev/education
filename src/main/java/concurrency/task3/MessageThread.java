package concurrency.task3;

public class MessageThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("some message");
        }
    }
}
