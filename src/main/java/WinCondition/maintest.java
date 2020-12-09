package WinCondition;


import BSTree.BinaryTree;
import Challenges.Generator;
import Printer.PrinterBST;
import TreeTracker.Tracker;

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

        int id = 3;
        int player = 1;
        int data = 3;

        Tracker tracker = new Tracker();



        if (Generator.obtenerInstancia().getCurrentChallenge() == id){
            if (id == 0){
                tracker.addNode(player, data, 0);
            } else if (id == 1){
                tracker.addNode(player, data, 1);
            }else if (id == 2){
                tracker.addNode(player, data, 2);
            }else if (id == 3){
                tracker.addNode(player, data, 3);
            }
        }






        Generator.obtenerInstancia().setCurrentChallenge(0);
        Generator.obtenerInstancia().setCurrentWinCondition(4);

        tracker.addNode(1, 21, 0);
        tracker.addNode(1, 43, 0);
        tracker.addNode(1, 65, 0);
        tracker.addNode(1, 78, 0);
        tracker.addNode(1, 23, 0);
        tracker.addNode(1, 76, 0);

        CheckWin win = new CheckWin();

        System.out.println(win.checkBTSWin(tracker.getBSTP1(), Generator.obtenerInstancia().getCurrentWinCondition()));

        PrinterBST printer = new PrinterBST();
        printer.GenerateString("", tracker.getBSTP1().getRoot());
        printer.PrintTree();



    }
}
