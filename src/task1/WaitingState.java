package task1;

public class WaitingState implements Runnable {
    public static Thread t1;

    @Override
    public void run() {
        Thread t2 = new Thread(new DemoThreadWS());
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(t2.getState());
        }
    }
}

class DemoThreadWS implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            //throw new InterruptedException();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(WaitingState.t1.getState());

                  }
    }
}