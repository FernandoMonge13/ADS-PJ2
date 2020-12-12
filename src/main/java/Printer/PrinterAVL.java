package Printer;
import AVLTree.NodeAVL;

/**
 * @author Marco Rodriguez
 * @version 1.0
 */
public class PrinterAVL {
    private String txt = "";

    /**
     * Funcion encargada de generar los strings para mostrar los arboles en pantalla
     * @param prefix String a concatenar
     * @param n Raiz del arbol del cual se desea la representacion grafica
     */
    public void GenerateString(String prefix, NodeAVL n) {
        if (n != null) {
            if (n.getRight() != null){
                GenerateString(prefix + "    |", n.getRight());
            }

            txt += prefix + ("|-- ") + n.toShow() + "\n";

            if (n.getLeft() != null){
                GenerateString(prefix + "    |", n.getLeft());
            }
        }
    }

    /**
     * Resetea el valor del string para poder generar otro arbol
     */
    public void ResetTree(){
        this.txt = "";
    }

    /**
     * Funcion para obtener la representacion grafica del arbol
     * @return El string a mostrar
     */
    public String getString(){
        return txt;
    }
}
