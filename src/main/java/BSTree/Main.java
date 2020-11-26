package BSTree;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(5);
        tree.insert(40);

        tree.inOrder(tree.root);

        tree.searchNode(40);

        tree.deleteNode(8);
        /*tree.deleteNode(4);
        tree.deleteNode(5);
        tree.deleteNode(40);*/
        tree.inOrder(tree.root);

    }
}