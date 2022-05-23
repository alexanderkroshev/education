package concurrency.task3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Message implements Runnable {
    private final int period;
    private String mes;

    @Override
    public void run() {
        try {
            while (true) synchronized (Counter.class) {
                Counter.class.wait();
                if (Counter.count % period == 0)
                    System.out.println(mes);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}