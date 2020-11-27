package BSTree;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(5);
        tree.insert(40);

        tree.inOrder(tree.root);


        tree.delete(8);
        tree.clear();

        System.out.println("PICHA");
        tree.inOrder(tree.root);
        System.out.println("PICHA");
        tree.insert(40);
        tree.inOrder(tree.root);

    }
}