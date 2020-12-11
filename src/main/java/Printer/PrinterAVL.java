package Printer;


import AVLTree.NodeAVL;

public class PrinterAVL {
    private String txt = "";

    public void GenerateString(String prefix, NodeAVL n) {
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
