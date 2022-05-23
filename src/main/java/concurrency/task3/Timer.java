package concurrency.task3;

public class Timer implements Runnable{

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(1000);
                synchronized (Counter.class) {
                    Counter.count++;
                    System.out.println(Counter.count);
                    Counter.class.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

