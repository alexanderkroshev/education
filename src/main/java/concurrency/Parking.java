package concurrency;

import concurrency.task4.Car;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Parking {
    static int PARKING_SIZE = 5;
    static final boolean[] PARKING_PLACES = new boolean[PARKING_SIZE];
    static final Semaphore SEMAPHORE = new Semaphore(PARKING_SIZE, true);

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(200);
        }
    }

}

