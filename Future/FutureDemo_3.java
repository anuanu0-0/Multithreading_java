package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Polling and Cancelling tasks
public class FutureDemo_3 {
    static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        System.out.println(pollingStatusAndCancelTask(10));
        threadPool.shutdown();
    }

    static int pollingStatusAndCancelTask(final int n) throws Exception {
        int result = -1;

        Callable<Integer> sumTask = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                // Wait for 10 ms
                Thread.sleep(10);

                int sum = 0;
                for (int i = 1; i <= n; i++)
                    sum += i;
                return sum;
            }            
        };

        Callable<Void> randomTask = new Callable<Void>() {
            public Void call() throws Exception {
                // Wait for an hour
                Thread.sleep(3600 * 1000);
                return null;
            }
        };

        Future<Integer> future1 = threadPool.submit(sumTask);
        Future<Void> future2 = threadPool.submit(randomTask);

        // Poll for completion of first task
        try { 
            // Before we poll for completion of second task,
            // cancel the second one
            future2.cancel(true);

            // Polling the future to check the status of the 
            // first submitted task
            while (!future1.isDone()) {
                System.out.println("Waiting for first task to complete.");
            }
            result = future1.get();
        } catch (ExecutionException ee) {
            System.out.println("Something went wrong.");
        }

        System.out.println("\nIs second task cancelled : " + future2.isCancelled());
        return result;
    }
}
