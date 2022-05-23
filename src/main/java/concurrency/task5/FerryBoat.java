package concurrency.task5;

import lombok.SneakyThrows;

public class FerryBoat implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(600);
        System.out.println("ferry boat moved all boats");
    }
}
