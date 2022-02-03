package Thread_Creation;
class ThreadCreation_1 {
    public static void main(String args[]) {

        // Thread creation by using Thread and Runnable interface using anonymous class
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("Say Hello");
           } 
        });
        thread.start();

        // Thread creation usinf Lambda Function. 
        Thread threadLambda = new Thread(() -> System.out.println("Lambda Expression"));
        threadLambda.start();
    }
}