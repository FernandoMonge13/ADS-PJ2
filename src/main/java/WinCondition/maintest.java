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


        Runtime runtime = Runtime.getRuntime();
        try{
            String path = Paths.get("").toAbsolutePath().toString();
            path = path + "\\UI\\InterfazGráfica.exe";
            Process process = runtime.exec(path);
        }catch (Exception exception){}

        //Generator.obtenerInstancia().setCurrentChallenge(0);
        //Generator.obtenerInstancia().setCurrentWinCondition(6);

        try {
            if (JavaSocket.Init()) {
            }
            Timer timer  = new Timer();
            Thread t = new Thread(timer);
            t.start();
            //Generator.obtenerInstancia().generateChallenge();
            //System.out.println(Generator.obtenerInstancia().getCurrentChallenge());
            //System.out.println(Generator.obtenerInstancia().getCurrentWinCondition());
            Generator.obtenerInstancia().setCurrentWinCondition(2);
            Generator.obtenerInstancia().setCurrentChallenge(0);

            System.out.println("El desafio actual tiene como id:" + 0);
            System.out.println("El numero de nodos o profundidad que es necesario para ganar es de:" + 2);
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        } catch (IOException e) {
            System.out.println("Error in javasocket");
        }

        while (true) {

            try {
                if (JavaSocket.Init()) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("Error in javasocket");
            }
        }

    }
}
