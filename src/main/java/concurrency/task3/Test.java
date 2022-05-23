package concurrency.task3;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

public class Test {
    static Object lock = new Object();

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread clockThread = new Thread(new Clock(worker));
        Thread messagerThread = new Thread(new Messenger(worker));
        clockThread.start();
        messagerThread.start();
    }
}

///////////////////////////////////////
class Worker {
    int seconds = 0;

    @SneakyThrows
    public void clock() {
        synchronized (Test.lock) {
            System.out.println(seconds);
            Thread.sleep(300);
            seconds++;
            while (seconds % 5 == 0) {//try to use if
                System.out.println(seconds);
                Test.lock.wait();
            }
            Test.lock.notify();
        }
    }

    @SneakyThrows
    public void message() {
        synchronized (Test.lock) {
            while (seconds % 5 != 0) {//try to use if
                Test.lock.wait();
            }
            seconds++;
            System.out.println("some message");
            Thread.sleep(300);
            Test.lock.notify();
        }
    }
}

/////////////////////////////////
@AllArgsConstructor
class Clock implements Runnable {
    Worker worker;

    @Override
    public void run() {
        while (true) {
            worker.clock();
        }
    }
}

////////////////////////////////////////////
@AllArgsConstructor
class Messenger implements Runnable {
    Worker worker;

    @Override
    public void run() {
        while (true) {
            worker.message();
        }
    }
}