package concurrency.task5;


import java.util.concurrent.BrokenBarrierException;

public class Car implements Runnable {
    int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("car_" + carNumber + " comes to ferry");
        try {
            Ferry.BARRIER.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("car_" + carNumber + " crossed the river");
    }
}
