package concurrency.task1;

public class Task1Runner {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
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

        //states: time_waiting
        Thread thread3 = new Thread(new TestThread2());
        thread3.start();
        Thread.sleep(300);
        System.out.println("state after wait(500): "+thread3.getState());


      //  states: waiting
        Object lock = new Object();
        Thread threadWait = new ThreadTestWait("wait thread", lock);
        threadWait.start();
        Thread.sleep(100);
        System.out.println("state using wait: "+ threadWait.getState());



    }
}
