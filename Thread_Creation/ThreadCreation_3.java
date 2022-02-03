package Thread_Creation;

public class ThreadCreation_3 {
    public static void main(String args[]) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        executeMe.join();
    }
}

// Subclassing thread class
class ExecuteMe extends Thread {

    @Override
    public void run() {
        System.out.println("I ran after extending Thread class");
    }
}
