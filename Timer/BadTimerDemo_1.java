package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class BadTimerDemo_1 {
    public static void main(String[] args) throws InterruptedException{
        Timer timer = new Timer();
        TimerTask badTask = new TimerTask() {

            @Override
            public void run() {
                // Run forever
                while(true);
            }
            
        };

        TimerTask goodTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Hello from the good task");                
            }
        };

        timer.schedule(badTask, 100);
        timer.schedule(goodTask, 500);

        Thread.sleep(3000);
    }
}