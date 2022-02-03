package Thread_Manipulation;

// Sleeping Threads
// Do not use sleep as a means for coordination among threads

public class ThreadManipulation_2 {
    public static void main( String args[] ) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        // innerThread.setDaemon(true);
        innerThread.start();
        innerThread.join();
        System.out.println("Main thread exiting.");
    }

    static class ExecuteMe implements Runnable {

        public void run() {
            System.out.println("Hello. innerThread going to sleep");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                // swallow interrupted exception
            }
        }
    }
}
