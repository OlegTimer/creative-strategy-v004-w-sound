import java.util.Timer;
import java.util.TimerTask;
public class Timer2
{
    public void go() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if(Sol.timeron<1){
                    timer.cancel();
                    return;
                }
                Sol.timerstep();
            }
        }, 0, Sol.timersleep);
    }
}

