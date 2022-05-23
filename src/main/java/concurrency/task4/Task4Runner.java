package concurrency.task4;

import lombok.SneakyThrows;

public class Task4Runner {
    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(200);
        }
    }
}
