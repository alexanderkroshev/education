package concurrency.task3;

public class TimeThread implements Runnable{

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long actual;

        while (true) {
            try {
            actual = System.currentTimeMillis();
            System.out.println(actual-start+ " millis from start");
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
