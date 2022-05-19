package concurrency.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
/*
        //states: new, runnable, blocked, terminated completed
        TestThread thread1 = new TestThread("first thread", counter);
        TestThread thread2 = new TestThread("second thread", counter);
        System.out.println("state after creating: "+thread1.getState());
        thread2.start();
        thread1.start();
        System.out.println("state during synchronization : "+thread1.getState());
        thread1.join(100);
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
        Thread thread5 = new Thread(new TestThread3());
        thread5.start();
        System.out.println("state using wait: "+ thread5.getState());



    }
}
