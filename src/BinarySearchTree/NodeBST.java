package BinarySearchTree;

public class NodeBST {
    int data;
    NodeBST right;
    NodeBST left;

    public NodeBST(int data){
        this.data =  data;
        this.right = null;
        this.left = null;
    }

    public int toShow(){
        return data;
    }
}
