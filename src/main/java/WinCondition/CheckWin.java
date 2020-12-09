package WinCondition;

import AVLTree.AVLTree;
import BSTree.BinaryTree;
import SplayTree.SplayTree;

public class CheckWin {

    public boolean checkBTSWin(BinaryTree tree, int winLimit){
        if (tree.getDepth(tree.getRoot()) >= winLimit){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAVLWin(AVLTree tree, int winLimit){
        if (tree.nodeCount(tree.getRoot()) >= winLimit){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkSplayWin(SplayTree tree, int winLimit){
        if (tree.nodeCount(tree.getRoot()) >= winLimit){
            return true;
        } else {
            return false;
        }
    }
//    public boolean checkBWin(BTree tree, int winLimit){
//        if (tree.getDepth(tree.getRoot()) == winLimit){
//            return true;
//        } else {
//            return false;
//        }
//    }

}
