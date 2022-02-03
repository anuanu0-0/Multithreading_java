package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Callable throwing Exception

public class FutureDemo_2 {
    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main( String args[] ) throws Exception {
        System.out.println( " sum: " + findSumWithException());
        threadPool.shutdown();
    }

    static int findSumWithException() throws ExecutionException, InterruptedException {
        int result = -1;
        
        Callable<Integer> sumTask = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                throw new RuntimeException("something bad happened.");
            }
        };
        
        Future<Integer> future = threadPool.submit(sumTask);
        try{
            result = future.get();
        } catch (ExecutionException ee) {
            System.out.println("Something went wrong. " + ee.getCause());
        }

        return result;
    }
}
