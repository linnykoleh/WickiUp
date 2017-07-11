package patterns._3_behavioral._5_mediator.live;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author LinnykOleh
 */
public class LiveMediator {

    private Timer timer;

    public LiveMediator(int seconds){
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
        timer.schedule(new RemindTaskWithoutBeep(), seconds * 2 * 1000);
    }

    public static void main(String[] args) {
        final LiveMediator liveMediator = new LiveMediator(2);
    }
}

class RemindTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("Times' up!");
    }
}

class RemindTaskWithoutBeep extends TimerTask{
    @Override
    public void run() {
        System.out.println("Now Time's really up!");
    }
}