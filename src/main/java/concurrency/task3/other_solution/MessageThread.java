package concurrency.task3.other_solution;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class MessageThread implements Runnable {

    Runnable sec;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (sec) {
            sec.wait();
        }
        System.out.println("message");
    }
}
