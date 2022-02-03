package Extras;

public class ThreadSleep {
    public static void main(String args[]) throws InterruptedException {
        String[] info = {
            "Todo 1 : Practice DSA",
            "Todo 2 : Read researh paper",
            "Todo 3 : Learn new development skills",
            "Todo 4 : Build cool projects"
        };

        for(int i=0; i<info.length; i++) {
            // Pause for 5 seconds
            Thread.sleep(5000);
            System.out.println(info[i]);
        }
    }
}
