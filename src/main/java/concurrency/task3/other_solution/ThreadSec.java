package concurrency.task3.other_solution;

import lombok.SneakyThrows;

public class ThreadSec implements Runnable {

    public int sec;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
            int n = 0;
            while (n < 5) {
                Thread.sleep(300);
                sec++;
                System.out.println(sec);
                n++;
            }
            notify();
        }

    }
}
