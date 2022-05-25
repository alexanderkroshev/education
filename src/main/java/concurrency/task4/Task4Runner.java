package concurrency.task4;


import java.util.concurrent.Semaphore;

public class Task4Runner {
    public static void main(String[] args) throws InterruptedException {
         int PARKING_SIZE = 5;
         boolean[] PARKING_PLACES = new boolean[PARKING_SIZE];
        Semaphore SEMAPHORE = new Semaphore(PARKING_SIZE, true);

        for (int i = 0; i < 10; i++) {
            new Car(i).start();
            Thread.sleep(200);
        }
    }
}
