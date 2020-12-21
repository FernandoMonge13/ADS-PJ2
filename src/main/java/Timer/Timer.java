package Timer;
import Challenges.Generator;
import java.util.concurrent.TimeUnit;

/**
 * @author Marco Rodriguez
 * @version 1.0
 */
public class Timer implements Runnable{
    public static boolean running = true;
    public static boolean challenge = false;
    public static boolean reset = false;

    /**
     * Funcion que inicia para empezar el cronometro
     */
    @Override
    public void run() {
        while (running){
            long starttime = System.currentTimeMillis();
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
                if (secondspassed == 300) {
                    try{
                        Runtime runtime = Runtime.getRuntime();
                        runtime.exec("Taskkill /IM InterfazGráfica.exe /F");
                    }
                    catch (Exception e){
                        System.out.println("error");
                    }
                }

            }
        }
    }
}
