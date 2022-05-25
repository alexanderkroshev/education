package concurrency.task4;


public class Task4Runner {
    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking(5);

        for (int i = 0; i < 10; i++) {
            new Car(i, parking).start();
            Thread.sleep(200);
        }
    }
}

