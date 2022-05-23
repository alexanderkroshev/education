package concurrency.task3;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Worker {
    int seconds = 0;
    final Object lock;

    @SneakyThrows
    public void clock() {
        synchronized (lock) {
            System.out.println(seconds);
            Thread.sleep(300);
            seconds++;
            while (seconds % 5 == 0) {
                System.out.println(seconds);
                lock.wait();
            }
            lock.notify();
        }
    }

    @SneakyThrows
    public void message() {
        synchronized (lock) {
            while (seconds % 5 != 0) {
                lock.wait();
            }
            seconds++;
            System.out.println("some message");
            Thread.sleep(300);
            lock.notify();
        }
    }

    @SneakyThrows
    public void anotherMessage() {
//        synchronized (lock) {
//            while (seconds % 5 != 0) {
//                lock.wait();
//            }
//            seconds++;
//            System.out.println("some message");
//            Thread.sleep(1000);
//            lock.notify();
//        }
    }
}