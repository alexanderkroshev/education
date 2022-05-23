package concurrency.task5;

import java.util.concurrent.CyclicBarrier;

public class Ferry {
    public static final CyclicBarrier BARRIER = new CyclicBarrier(
            3, new FerryBoat());
}
