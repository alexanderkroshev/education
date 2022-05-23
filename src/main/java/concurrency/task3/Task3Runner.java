package concurrency.task3;

public class Task3Runner {
    public static void main(String[] args) {
        new Thread(new Timer()).start();
        new Thread(new Message(5, "message1!")).start();
        new Thread(new Message(7, "message2!")).start();
    }
}
