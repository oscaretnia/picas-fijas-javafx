import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
  public static void main(String[] args) {
    System.out.println("Starting up...");
    
    
    //repeating timer: prints stuff every 10s
    Timer myRepeatingTimer = new Timer();
    myRepeatingTimer.scheduleAtFixedRate(new TimerTask(){
        @Override
        public void run(){
            
        }
    }, 0, 1000);
    
  }
}