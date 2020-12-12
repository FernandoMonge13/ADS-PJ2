package AVLTree;

import BSTree.NodeBST;

public class AVLTree {

    private NodeAVL root;

    /**
     * Constructor
     */
    public AVLTree() {
        root = null;
    }

    /**
     * Get root value
     * @return root node
     */
    public NodeAVL getRoot(){
        return root;
    }

    /**
     * Search node
     * @param info node info is being searching
     * @param r where start to search
     */
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

    /**
     * Cleans the tree
     */
    public void clear(){
        root = null;
    }

    /**
     * Deletes an specific node
     * @param data node value to delete
     */
    public void delete(int data){
        NodeAVL aux = root;
        NodeAVL dad = root;
        boolean child = true;
        while (aux.data != data){
            dad = aux;
            if(data < aux.data){
                child = true;
                aux = aux.left;
            }
            else{
                child = false;
                aux = aux.right;
            }
        }

        if(aux == root){
            root = null;
        }else if(child){
            dad.left = null;
        }
        else{
            dad.right = null;
        }
    }

    /**
     * Balance Value
     * @param node node to get the value
     * @return node valance value
     */
    public int getFe(NodeAVL node){
        if (node == null){
            return -1;
        }else{
            return node.fe;
        }
    }

    /**
     * Single left rotation
     * @param node node to rotate
     * @return auxiliary node
     */
    public NodeAVL leftRotation(NodeAVL node){
        NodeAVL aux = node.left;
        node.left = aux.right;
        aux.right = node;
        node.fe = Math.max(getFe(node.left), getFe(node.right)) + 1;
        aux.fe = Math.max(getFe(aux.left), getFe(aux.right)) + 1;
        return aux;
    }

    /**
     * Single right rotation
     * @param node node to rotate
     * @return auxiliary node
     */
    public NodeAVL rightRotation(NodeAVL node){
        NodeAVL aux = node.right;
        node.right = aux.left;
        aux.left = node;
        node.fe = Math.max(getFe(node.left), getFe(node.right)) + 1;
        aux.fe = Math.max(getFe(aux.left), getFe(aux.right)) + 1;
        return aux;
    }

    /**
     * Double right rotation
     * @param node node to rotate
     * @return auxiliary node
     */
    public NodeAVL leftDoubleRotation(NodeAVL node){
        NodeAVL aux;
        node.left = rightRotation(node.left);
        aux = leftRotation(node);
        return aux;
    }

    /**
     * Double left rotation
     * @param node node to rotate
     * @return auxiliary node
     */
    public NodeAVL rightDoubleRotation(NodeAVL node){
        NodeAVL aux;
        node.right = leftRotation(node.right);
        aux = rightRotation(node);
        return aux;
    }

    /**
     * Insert a node to the tree
     * @param newNode node to insert
     * @param subtree subtree of the node
     * @return dad of that node
     */
    public NodeAVL insertAVl(NodeAVL newNode, NodeAVL subtree){
        NodeAVL newDad = subtree;

        if (newNode.data < subtree.data){
            if (subtree.left == null){
                subtree.left = newNode;
            }
            else{
                subtree.left = insertAVl(newNode, subtree.left);
                if ((getFe(subtree.left) - getFe(subtree.right)) == 2){
                    if (newNode.data < subtree.left.data){
                        newDad = leftRotation(subtree);
                    }
                    else{
                        newDad = leftDoubleRotation(subtree);
                    }
                }
            }
        }
        else if(newNode.data > subtree.data){
            if (subtree.right == null){
                subtree.right = newNode;

            }
            else{
                subtree.right = insertAVl(newNode, subtree.right);
                if ((getFe(subtree.right) - getFe(subtree.left)) == 2){
                    if (newNode.data > subtree.right.data){
                        newDad = rightRotation(subtree);
                    }
                    else{
                        newDad = rightDoubleRotation(subtree);
                    }
                }
            }

        }
        else{
            System.out.println("Duplicated");
        }

        if ((subtree.left == null) && (subtree.right != null)){
            subtree.fe = subtree.right.fe +1;
        }
        else if ((subtree.right == null) && (subtree.left != null)){
            subtree.fe = subtree.left.fe+1;
        }
        else {
            subtree.fe = Math.max(getFe(subtree.left), getFe(subtree.right)) +1;
        }
        return newDad;
    }

    /**
     * Insert a new node value
     * @param data node value
     */
    public void insert(int data){
        NodeAVL newNode = new NodeAVL(data);
        if (root == null){
            root = newNode;
        }
        else{
            root = insertAVl(newNode, root);
        }
    }

    /**
     * Inorder showing process
     * @param r root value
     */
    public void inOrder(NodeAVL r){
        if (r != null){
            inOrder(r.left);
            System.out.print(r.data + ", ");
            inOrder(r.right);
        }
    }

    /**
     * Preorder showing process
     * @param r root value
     */
    public void preOrder(NodeAVL r){
        if (r != null){
            System.out.print(r.data + ", ");
            preOrder(r.left);
            preOrder(r.right);
        }
    }

    /**
     * Postorder showing process
     * @param r root value
     */
    public void postOrder(NodeAVL r){
        if (r != null){
            postOrder(r.left);
            postOrder(r.right);
            System.out.print(r.data + ", ");
        }
    }

    /**
     * Node count
     * @param node node to start counting
     * @return among of nodes
     */
    public int nodeCount(NodeAVL node){
        int c =  1;
        if (node == null)
            return 0;
        else
        {
            c += nodeCount(node.getRight());
            c += nodeCount(node.getLeft());
            return c;
        }
    }

}
