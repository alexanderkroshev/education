package concurrency.task4;

import java.util.concurrent.Semaphore;

public class Parking extends Thread{
    private int PARKING_SIZE;
    private volatile boolean[] PARKING_PLACES;
    private volatile Semaphore SEMAPHORE;

    public Parking(int parking_size) {
        PARKING_SIZE = parking_size;
        PARKING_PLACES = new boolean[PARKING_SIZE];
        SEMAPHORE = new Semaphore(PARKING_SIZE, true);
    }

    public boolean[] getPARKING_PLACES() {
        return PARKING_PLACES;
    }

    public Semaphore getSEMAPHORE() {
        return SEMAPHORE;
    }
}

