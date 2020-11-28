package Printer;

import BSTree.NodeBST;
import SplayTree.NodeSplay;

public class PrinterSplay {
    private String txt = "";

    public void GenerateString(String prefix, NodeSplay n) {
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
}
