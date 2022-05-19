package concurrency.task1;

import concurrency.task1.waiting.Data;
import concurrency.task1.waiting.SynchronizedReceiver;
import concurrency.task1.waiting.SynchronizedSender;

public class Task1Runner {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
/*
        //states: new, runnable, blocked, terminated
        TestThread thread1 = new TestThread("first thread", counter);
        TestThread thread2 = new TestThread("second thread", counter);
        System.out.println("state after creating: "+thread1.getState());
        thread2.start();
        thread1.start();
        System.out.println("state during running : "+thread1.getState());
        thread1.join(200);
        System.out.println("state after join: "+thread1.getState());
        Thread.sleep(2000);
        System.out.println("state after finishing: "+thread1.getState());

        //states: time_waiting completed
        Thread thread3 = new Thread(new TestThread2());
        thread3.start();
        Thread.sleep(300);
        System.out.println("state after wait(500): "+thread3.getState());

*/
      //  states: waiting
        Data data = new Data();
        Thread receiverThread = new Thread(new SynchronizedReceiver(data), "receiver-thread");
        Thread senderThread = new Thread(new SynchronizedSender(data), "sender-thread");
        receiverThread.start();
        senderThread.start();
        System.out.println("state after wait: "+receiverThread.getState());





    }
}
