package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Using Future and Callable Together
public class FutureDemo_1 {

    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception{
        System.out.println("Sum : " + findSum(10));
        threadPool.shutdown();
    }

    static int findSum(final int n) throws ExecutionException, InterruptedException {
        Callable<Integer> sumTask = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= n; i++)
                    sum += i;
                return sum;
            }
        };

        Future<Integer> future = threadPool.submit(sumTask);
        return future.get();
    }
    
}
