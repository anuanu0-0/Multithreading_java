package Callable;

import java.util.concurrent.Callable;

public class SumTaskMethod_2{
    final int n = 10;

    Callable<Integer> sumTask = new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for(int i=1; i<=n; i++) {
                sum += i;
            }
            return sum;
        }    
    };
}
