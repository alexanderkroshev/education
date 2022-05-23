package concurrency.task5;


import lombok.SneakyThrows;

public class Task5Runner {
    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            Thread.sleep(400);
            new Thread(new Car(i)).start();
        }
    }
}
