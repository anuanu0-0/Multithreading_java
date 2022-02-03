package Executors;

import java.util.concurrent.Executor;

// Creating a dummy thread executor 

public class ThreadExecutor {
    public static void main(String[] args) {
        DumbExecutor myExecutor = new DumbExecutor();
        MyTask myTask = new MyTask();
        myExecutor.execute(myTask);
    }

    static class DumbExecutor implements Executor {
        // Takes a runnable interface object
        @Override
        public void execute(Runnable command) {
            Thread newThread = new Thread(command);
            newThread.start();
        }
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Task is running now...");            
        }

    }
}
