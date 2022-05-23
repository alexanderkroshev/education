package concurrency.task3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageThread implements Runnable {
    Worker worker;

    @Override
    public void run() {
        while (true) {
            worker.message();
        }
    }
}