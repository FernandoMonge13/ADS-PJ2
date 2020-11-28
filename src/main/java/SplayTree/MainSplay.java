package SplayTree;

import Printer.PrinterSplay;

public class MainSplay {
    public static void main(String[] args) {
        SplayTree spt = new SplayTree();
        spt.insert(14);
        spt.insert(28);
        spt.insert(19);
        spt.insert(5);


        PrinterSplay prueba = new PrinterSplay();
        prueba.GenerateString("", spt.getRoot());
        prueba.PrintTree();
        prueba.ResetTree();
        //spt.clear();
//
//        spt.inOrder();
//        System.out.println("HOLA");
//
//
//        spt.postOrder();
//        System.out.println("HOLA");
//
//        spt.preOrder();
//        System.out.println("HOLA");

    }
}
