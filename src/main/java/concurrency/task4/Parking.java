package concurrency.task4;

import java.util.concurrent.Semaphore;

public class Parking {
    static int PARKING_SIZE = 5;
    static final boolean[] PARKING_PLACES = new boolean[PARKING_SIZE];
    static final Semaphore SEMAPHORE = new Semaphore(PARKING_SIZE, true);
}
