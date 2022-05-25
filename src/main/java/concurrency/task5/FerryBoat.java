package concurrency.task5;


public class FerryBoat implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ferry boat moved 3 cars");
    }
}
