package AVLTree;

import BSTree.NodeBST;

public class NodeAVL {
    int data;
    int fe;
    NodeAVL left;
    NodeAVL right;

    public NodeAVL(int data) {
        this.data = data;
        this.fe = 0;
        this.left = null;
        this.right = null;
    }

    public int toShow() {
        return data;
    }

    public NodeAVL getLeft(){
        return this.left;
    }

    public NodeAVL getRight(){
        return this.right;
    }
}
