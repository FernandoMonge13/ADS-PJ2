package BSTree;

import Printer.PrinterBST;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(4);
        tree.insert(5);
        tree.insert(40);
        tree.insert(83);
        tree.insert(423);
        tree.insert(12);
        tree.insert(1);
        tree.insert(999);
        tree.insert(245);
        tree.insert(876);


        PrinterBST prueba = new PrinterBST();

        prueba.GenerateString("", tree.root);
        prueba.PrintTree();
        prueba.ResetTree();
//
//
//        tree.delete(8);
//        tree.clear();
//
//        System.out.println("PICHA");
//        tree.inOrder(tree.root);
//        System.out.println("PICHA");
//        tree.insert(40);
//        tree.inOrder(tree.root);

    }
}