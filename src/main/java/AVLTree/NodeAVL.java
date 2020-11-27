package AVLTree;

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
}
