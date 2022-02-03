# Problem : Consumer-Producer 

## Sequential Approach 
``` Java
void revieveAndExecuteClientOrders() {
    while(true) {
        Order order = waitForNextOrder();
        order.execute();
    }
}
```

## Unbounded Thread Approach

```Java
void revieveAndExecuteClientOrdersBetter() {
    while(true) {
        final Order order = waitForNextOrder();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                order.executor();
            }
        });

        thread.start();
    }
}
```

Creating threads without bound is not a wise approach for the following reasons:

- Thread creation and teardown isn't for free.
- Active threads consume memory even if they are idle. If there are less number of processors than threads then several of them will sit idle tying up memory.
- There is usually a limit imposed by JVM and the underlying OS on the number of threads that can be created.

## Thread Pools
- Allow us to decouple task submission and execution.
- In below example, using factory method exposed by the executors class to get an instance of the thread pool.
```Java
void recieveAndExecutorClientOrderBest() {
    int expectedConcurrentOrders = 100;
    Executor executor = Executors.newFixedThreadPool(expectedConcurrentOrders);
    while(true) {
        final Order order = waitForNextOrder();
        executor.executor(new Runnable() {
            public void run() {
                order.execute();
            }
        });
    }
}
``` 