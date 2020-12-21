package WinCondition;
import AVLTree.AVLTree;
import BSTree.BinaryTree;
import BTree.BTree;
import SplayTree.SplayTree;

/**
 * @author Marco Rodriguez
 * @version 1.0
 */
public class CheckWin {

    /**
     * Funcion que se encarga de verificar si se cumplio con la condicion de victoria del arbol BST
     * @param tree Arbol a comparar
     * @param winLimit Valor que debe de cumplir
     * @return Valor booleano dependiendo de si cumple o no con los requisitos
     */
    public boolean checkBTSWin(BinaryTree tree, int winLimit){
        if (tree.getDepth(tree.getRoot()) >= winLimit){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Funcion que se encarga de verificar si se cumplio con la condicion de victoria del arbol AVL
     * @param tree Arbol a comparar
     * @param winLimit Valor que debe de cumplir
     * @return Valor booleano dependiendo de si cumple o no con los requisitos
     */
    public boolean checkAVLWin(AVLTree tree, int winLimit){
        if (tree.nodeCount(tree.getRoot()) >= winLimit){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Funcion que se encarga de verificar si se cumplio con la condicion de victoria del arbol Splay
     * @param tree Arbol a comparar
     * @param winLimit Valor que debe de cumplir
     * @return Valor booleano dependiendo de si cumple o no con los requisitos
     */
    public boolean checkSplayWin(SplayTree tree, int winLimit){
        if (tree.nodeCount(tree.getRoot()) >= winLimit){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Funcion que se encarga de verificar si se cumplio con la condicion de victoria del arbol B
     * @param tree Arbol a comparar
     * @param winLimit Valor que debe de cumplir
     * @return Valor booleano dependiendo de si cumple o no con los requisitos
     */
    public boolean checkBWin(BTree tree, int winLimit){
        if (tree.size() >= winLimit){
            return true;
        } else {
            return false;
        }
    }

}
