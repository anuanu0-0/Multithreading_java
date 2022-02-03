package Callable;

import java.util.concurrent.Callable;

public class SumTaskMethod_1 implements Callable<Integer> {

    int n;

    public SumTaskMethod_1(int n) {
        this.n = n;
    }

    // Declaring a task
    @Override
    public Integer call() throws Exception {
        if(n<=0)
            return 0;
        
        int sum = 0;
        for(int i=1; i<=n; i++) {
            sum += i;
        }

        return sum;
    }
}
