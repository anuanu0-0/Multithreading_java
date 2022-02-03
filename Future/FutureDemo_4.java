package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// Implementing FutureTask

public class FutureDemo_4 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable() {
            public Object call() throws Exception {
                try {
                    Thread.sleep(1);
                } catch(InterruptedException ie) {
                    // Empty 
                }
                return 0;
            }
        });

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future duplicateFuture = threadPool.submit(futureTask);

        while(!futureTask.isDone()) {
            System.out.println("Waiting");
        }

        if(duplicateFuture.isDone() != futureTask.isDone()) {
            System.out.println("This should never happen");
        }

        System.out.println((int)futureTask.get());
        threadPool.shutdown();
    }
}
