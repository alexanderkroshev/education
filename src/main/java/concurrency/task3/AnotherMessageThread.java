package concurrency.task3;

public class AnotherMessageThread implements Runnable{

    @Override
    public void run() {
        while (true){
        try {
            Thread.sleep(7000);
            System.out.println("another message");
                    } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
}
