package Thread_Manipulation;
// Daemon thread & Joining threads
public class ThreadManipulation_1 {
    public static void main(String[] args) throws InterruptedException{
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);

        // Daemon thread runs in the background
        // Terminate the innerthread if its running when main thread exits
        // innerThread.setDaemon(true);
        innerThread.start();

        // Calling the join method on innerThread so that main thread suspends its execution
        // If daemon is true and join is not called innerThread may get killed by the JVM upon main thread's completion
        innerThread.join();
    }
}

class ExecuteMe implements Runnable {
    static int i=0;
    @Override
    public void run() {
        while(true) {
            System.out.println("Hello World" + i++);
            try{
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // Swallow interrupted execution
            }
        }
    }
}
