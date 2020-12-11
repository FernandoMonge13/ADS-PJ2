package Printer;

import BSTree.BinaryTree;
import BSTree.NodeBST;

import java.util.ArrayList;
import java.util.List;

public class PrinterBST {
    private String txt = "";

    public void GenerateString(String prefix, NodeBST n) {
        if (n != null) {
            if (n.getRight() != null){
                GenerateString(prefix + "    |", n.getRight());
           }

            //System.out.println (prefix + ("|-- ") + n.toShow());
            txt += prefix + ("|-- ") + n.toShow() + "\n";

            if (n.getLeft() != null){
                GenerateString(prefix + "    |", n.getLeft());
            }
        }
    }

    public void PrintTree(){
        System.out.println(txt);
    }

    public void ResetTree(){
        this.txt = "";
    }

    public String getString(){
        return txt;
    }
}
