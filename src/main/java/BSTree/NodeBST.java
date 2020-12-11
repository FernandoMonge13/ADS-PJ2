package BSTree;

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

    public NodeBST getLeft(){
        return this.left;
    }

    public NodeBST getRight(){
        return this.right;
    }
}
