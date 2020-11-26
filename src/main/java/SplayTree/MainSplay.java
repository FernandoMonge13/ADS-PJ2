package SplayTree;

public class MainSplay {
    public static void main(String[] args) {
        SplayTree spt = new SplayTree();
        spt.insert(14);
        spt.insert(28);
        spt.insert(19);
        //spt.clear();

        spt.inOrder();


        spt.postOrder();

        spt.preOrder();

    }
}
