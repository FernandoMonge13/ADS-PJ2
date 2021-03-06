package SplayTree;

import AVLTree.NodeAVL;
import BSTree.NodeBST;

public class SplayTree {
    private  NodeSplay root;
    private int count = 0;

    public SplayTree() {
        root = null;
    }

    /**
     * Check if the tree is empty
     * @return is empty or not
     *
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Cleans the tree
     */
    public void clear(){
        root = null;
        count = 0;
    }

    /**
     * @return root node
     */
    public NodeSplay getRoot() {
        return root;
    }

    /**
     * Insert Element
     * @param data new node value
     */
    public void insert(int data){
        NodeSplay aux = root;
        NodeSplay p = null;
        while (aux != null){
            p = aux;
            if (data > p.data){
                aux = aux.right;
            }
            else{
                aux = aux.left;
            }
        }

        aux = new NodeSplay();
        aux.data = data;
        aux.parent = p;

        if (p == null){
            root = aux;
        }
        else if (data > p.data){
            p.right = aux;
        }
        else{
            p.left = aux;

        }
        Splay(aux);
        count ++;
    }

    /**
     * Single left rotation
     * @param c child
     * @param p parent
     */
    public void leftChildParent(NodeSplay c, NodeSplay p){
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p)){
            throw new RuntimeException("Wrong");
        }
        if (p.parent != null){
            if(p == p.parent.left){
                p.parent.left = c;
            }
            else{
                p.parent.right = c;
            }
        }
        if (c.right != null){
            c.right.parent = p;
        }
        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }

    /**
     * Single right rotation
     * @param c child
     * @param p parent
     */
    public void rightChildParent(NodeSplay c, NodeSplay p){
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p)){
            throw new RuntimeException("Wrong");
        }
        if (p.parent != null){
            if(p == p.parent.left){
                p.parent.left = c;
            }
            else{
                p.parent.right = c;
            }
        }
        if (c.left != null){
            c.left.parent = p;
        }
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }

    /**
     * Splay Core
     * @param x node
     */
    private void Splay(NodeSplay x){

        while (x.parent != null){
            NodeSplay splayParent = x.parent;
            NodeSplay splayGrandParent = splayParent.parent;

            if (splayGrandParent == null){
                if (x == splayParent.left){
                    leftChildParent(x, splayParent);
                }
                else{
                    rightChildParent(x, splayParent);
                }
            }
            else{
                if (x == splayParent.left){
                    if (splayParent == splayGrandParent.left){
                        leftChildParent(splayParent, splayGrandParent);
                        leftChildParent(x, splayParent);
                    }
                    else{
                        leftChildParent(x, x.parent);
                        rightChildParent(x, x.parent);
                    }

                }
                else{
                    if (splayParent == splayGrandParent.left){
                        rightChildParent(x, x.parent);
                        leftChildParent(x, x.parent);
                    }
                    else{
                        rightChildParent(splayParent, splayGrandParent);
                        rightChildParent(x, splayParent);
                    }
                }
            }
        }
        root = x;

    }

    /**
     * Delete an specific node
     * @param node node to delete
     */
    private void delete(NodeSplay node){
        if (node == null){
            return;
        }
        Splay(node);
        if ((node.left != null) && (node.right != null)){
            NodeSplay min = node.left;
            while (min.right != null){
                min = min.right;
            }
            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        }
        else if (node.left != null){
            node.left.parent = null;
            root = node.left;
        }
        else{
            root = null;
        }
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        count--;
    }

    /**
     * @return size or count
     */
    public int getCount() {
        return count;
    }

    /**
     * Search a node
     * @param data value ti find
     * @return find operation
     */
    public boolean search(int data){
        return findNode(data) != null;
    }

    /**
     * Find a node
     * @param data value to search
     * @return node were searched
     */
    private NodeSplay findNode(int data){
        NodeSplay prevNode = null;
        NodeSplay z = root;
        while (z != null){
            prevNode = z;
            if (data > z.data){
                z = z.right;
            }
            else if (data < z.data){
                z = z.left;

            }
            else if (data == z.data){
                Splay(z);
                return z;
            }
        }
        if (prevNode != null){
            Splay(prevNode);
            return null;
        }
        return null;
    }

    /**
     *Postorder showing process
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * Postorder showing process
     * @param r root value
     */
    private void inOrder(NodeSplay r){
        if (r != null){
            inOrder(r.left);
            System.out.print(r.data + " ");
            inOrder(r.right);
        }
    }

    /**
     * Preorder showing process
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * Preorder showing process
     * @param r root value
     */
    private void preOrder(NodeSplay r){
        if (r != null){
            System.out.print(r.data + " ");
            postOrder(r.left);
            postOrder(r.right);

        }

    }

    /**
     * Postorder showing process
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * Postorder showing process
     * @param r root value
     */
    private void postOrder(NodeSplay r){
        if (r != null){
            postOrder(r.left);
            postOrder(r.right);
            System.out.print(r.data + " ");
        }
    }

    /**
     * Among of nodes
     * @param node node to start
     * @return among of nodes
     */
    public int nodeCount(NodeSplay node){
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
