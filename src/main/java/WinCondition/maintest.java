package WinCondition;


import BSTree.BinaryTree;
import Challenges.Generator;
import Printer.PrinterBST;
import Timer.Timer;
import TreeTracker.Tracker;
import communication.JavaSocket;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class maintest {
    public static void main(String args[]) throws InterruptedException {
//        long displayMinutes = 0;
//        long starttime = System.currentTimeMillis();
//        System.out.println("Timer:");
//        while (true) {
//            TimeUnit.SECONDS.sleep(1);
//            long timepassed = System.currentTimeMillis() - starttime;
//            long secondspassed = timepassed / 1000;
//            if (secondspassed == 60) {
//                secondspassed = 0;
//                starttime = System.currentTimeMillis();
//            }
////            if ((secondspassed % 5) == 0){
////                Generator.obtenerInstancia().generateChallenge();
////                System.out.println(Generator.obtenerInstancia().getCurrentChallenge());
////                System.out.println(Generator.obtenerInstancia().getCurrentWinCondition());
////            }
//            if ((secondspassed % 60) == 0)
//                displayMinutes++;
//
//            System.out.println(displayMinutes + ":" + secondspassed);
//        }
//
//        int id = 3;
//        int player = 1;
//        int data = 3;
//
//
//
//
//        if (Generator.obtenerInstancia().getCurrentChallenge() == id){
//            if (id == 0){
//                tracker.addNode(player, data, 0);
//            } else if (id == 1){
//                tracker.addNode(player, data, 1);
//            }else if (id == 2){
//                tracker.addNode(player, data, 2);
//            }else if (id == 3){
//                tracker.addNode(player, data, 3);
//            }
//        }
//
//
//
//

        Runtime runtime = Runtime.getRuntime();
        try{
            String path = Paths.get("").toAbsolutePath().toString();
            path = path + "\\UI\\InterfazGráfica.exe";
            Process process = runtime.exec(path);
        }catch (Exception exception){}

        Generator.obtenerInstancia().setCurrentChallenge(0);
        Generator.obtenerInstancia().setCurrentWinCondition(6);

        while (true) {

            try {
                JavaSocket.Init();
            } catch (IOException e) {
                System.out.println("Error in javasocket");
            }
        }
        /*Tracker.obtenerInstancia().addNode(1, 21, 2);
        Tracker.obtenerInstancia().addNode(1, 43, 2);
        Tracker.obtenerInstancia().addNode(1, 65, 2);
        Tracker.obtenerInstancia().addNode(1, 78, 2);
        Tracker.obtenerInstancia().addNode(1, 23, 2);*/





//        Timer timer = new Timer();
//        Thread t = new Thread(timer);
//        t.start();


//        timer.stop();
    }
}
