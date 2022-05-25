package concurrency.task5;


public class Task5Runner {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 15; i++) {
            Thread.sleep(400);
            new Thread(new Car(i)).start();
        }
    }
}
