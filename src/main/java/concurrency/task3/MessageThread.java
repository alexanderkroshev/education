package concurrency.task3;


class MessageThread extends Thread {
    private final int period;
    private String mes;
    private Object lock;

    MessageThread(int period, String mes, Object lock) {
        this.period = period;
        this.mes = mes;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true)
                synchronized (lock) {
                    lock.wait();
                    if (Timer.getCount() % period == 0)
                        System.out.println(mes);
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}