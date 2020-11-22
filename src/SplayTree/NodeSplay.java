package SplayTree;

public class NodeSplay {
    NodeSplay left;
    NodeSplay right;
    NodeSplay parent;
    int data;

    public NodeSplay(){

    }

    public NodeSplay(int data) {
        this.data = data;
    }

    public NodeSplay(int data, NodeSplay left, NodeSplay right, NodeSplay parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;

    }
}
