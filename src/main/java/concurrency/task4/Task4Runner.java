package concurrency.task4;


public class Task4Runner {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(200);
        }
    }
}
