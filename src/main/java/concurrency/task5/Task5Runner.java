package concurrency.task5;


import java.util.concurrent.CyclicBarrier;

public class Task5Runner {
    final static CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            new Thread(new Car(i)).start();
        }
    }
}
