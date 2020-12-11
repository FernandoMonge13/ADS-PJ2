package Timer;

import java.util.concurrent.TimeUnit;

public class Timer implements Runnable{

    private boolean running = true;

    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {
        while (running){
            long displayMinutes = 0;
            long starttime = System.currentTimeMillis();
            System.out.println("Timer:");
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long timepassed = System.currentTimeMillis() - starttime;
                long secondspassed = timepassed / 1000;
                if (secondspassed == 60) {
                    secondspassed = 0;
                    starttime = System.currentTimeMillis();
                }
//            if ((secondspassed % 5) == 0){
//                Generator.obtenerInstancia().generateChallenge();
//                System.out.println(Generator.obtenerInstancia().getCurrentChallenge());
//                System.out.println(Generator.obtenerInstancia().getCurrentWinCondition());
//            }
                if ((secondspassed % 60) == 0)
                    displayMinutes++;


                System.out.println(displayMinutes + ":" + secondspassed);
            }
        }
    }
}
