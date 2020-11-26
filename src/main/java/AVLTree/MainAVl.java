package AVLTree;

public class MainAVl {
    public static void main(String[] args) {
        AVLTree try1 = new AVLTree();
        try1.insert(8);
        try1.insert(9);
        try1.insert(10);
        try1.insert(40);
        try1.insert(37);
        try1.insert(13);
        try1.inOrder(try1.getRoot());
        try1.deleteNodeAVL(8);
        try1.deleteNodeAVL(9);
        System.out.println("It works");
        try1.inOrder(try1.getRoot());
    }
}
