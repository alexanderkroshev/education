package concurrency.task3.other_solution;

import lombok.SneakyThrows;

public class TaskRunner {

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadSec());
        thread.start();
        new Thread(new MessageThread(thread)).start();
    }
}

