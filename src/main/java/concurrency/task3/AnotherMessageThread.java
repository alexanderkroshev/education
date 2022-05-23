package concurrency.task3;

public class AnotherMessageThread implements Runnable{
    Worker worker;

    @Override
    public void run() {
        while (true) {
            worker.message();
        }
    }

}
