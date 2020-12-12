package Timer;

import Challenges.Generator;

import java.util.concurrent.TimeUnit;

public class Timer implements Runnable{

    public static boolean running = true;

    public static boolean challenge = false;

    public static boolean reset = false;

    @Override
    public void run() {
        while (running){
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
                if (reset){
                    Generator.obtenerInstancia().generateChallenge();
                    challenge = true;
                    secondspassed = 0;
                    starttime = System.currentTimeMillis();
                }
                if (secondspassed == 60) {
                    Generator.obtenerInstancia().generateChallenge();
                    challenge = true;
                    secondspassed = 0;
                    starttime = System.currentTimeMillis();
                }

                System.out.println(secondspassed);
            }
        }
    }
}
