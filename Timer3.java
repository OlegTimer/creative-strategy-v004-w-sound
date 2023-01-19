import java.util.Timer;
import java.util.TimerTask;
public class Timer3 {
    public void go() {

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Sol.task.play();
            }
        }, 0, Sol.soundsleep);
    }
}
