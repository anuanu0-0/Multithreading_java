package Thread_Creation;
public class ThreadCreation_2 {
    public static void main(String args[]) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.start();
        thread.join();
    }
}

class ExecuteMe implements Runnable {

    public void run() {
        System.out.println("Hello World");
    }

}
