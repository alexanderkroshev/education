package concurrency.task5;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Car implements Runnable {
    int carNumber;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("car_" + carNumber + " comes to ferry");
        Ferry.BARRIER.await();
        System.out.println("car_" + carNumber + " crossed the river");
    }
}
