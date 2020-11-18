package AVLTree;

public class AVLTree {
    private NodeAVL root;

    public AVLTree() {
        root = null;
    }

    // Search node
    public NodeAVL search (int info, NodeAVL r){
        if (root == null){
            return null;

        }else if (r.data == info){
        return r;

        }else if (r.data < info){
            return search(info, r.right);
        }else{
            return search(info, r.left);
        }

    }

    // Balance Value
    public int getFe(NodeAVL node){
        if (node == null){
            return -1;
        }else{
            return node.fe;
        }
    }

    // Single left rotation
    public NodeAVL leftRotation(NodeAVL node){
        NodeAVL aux = node.left;
        node.left = aux.right;
        aux.right = node;
        node.fe = Math.max(getFe(node.left), getFe(node.right)) + 1;
        aux.fe = Math.max(getFe(aux.left), getFe(aux.right)) + 1;
        return aux;
    }

    // Single right rotation
    public NodeAVL rightRotation(NodeAVL node){
        NodeAVL aux = node.right;
        node.right = aux.left;
        aux.left = node;
        node.fe = Math.max(getFe(node.left), getFe(node.right)) + 1;
        aux.fe = Math.max(getFe(aux.left), getFe(aux.right)) + 1;
        return aux;
    }

    // Double right rotation
    public NodeAVL leftDoubleRotation(NodeAVL node){
        NodeAVL aux;
        node.left = rightRotation(node.left);
        aux = leftRotation(node);
        return aux;
    }

    // Double left rotation
    public NodeAVL rightDoubleRotation(NodeAVL node){
        NodeAVL aux;
        node.right = leftRotation(node.right);
        aux = rightRotation(node);
        return aux;
    }
}
