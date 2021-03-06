package BSTree;

public class BinaryTree {
    NodeBST root;

    public BinaryTree() {
        root = null;
    }

    /**
     * Insert a new node to the tree
     * @param data value to insert
     */
    public void insert(int data){
        NodeBST newNode = new NodeBST(data);
        if(root == null){
            root = newNode;
        }
        else{
            NodeBST aux = root;
            NodeBST dad;
            while(true){
                dad = aux;
                if(data < aux.data){
                    aux = aux.left;
                    if(aux == null){
                        dad.left = newNode;
                        return;
                    }
                }
                else{
                    aux = aux.right;
                    if(aux == null){
                        dad.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Cleans the tree
     */
    public void clear(){
        root = null;
    }

    /**
     * @return root node
     */
    public NodeBST getRoot() {
        return root;
    }

    /**
     * Inorder showing process
     * @param root root value
     */
    public void inOrder(NodeBST root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    /**
     * Preorder showing process
     * @param root root value
     */
    public void preOrder(NodeBST root){
        if (root != null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);

        }
    }

    /**
     * Postorder showing process
     * @param root root value
     */
    public void postOrder(NodeBST root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);

        }
    }

        public NodeBST searchNode(int data){
        NodeBST aux = root;

        while(aux.data != data){
            if(data < aux.data){
                aux = aux.left;
            }
            else{
                aux = aux.right;
            }
            if(aux == null){
                return null;
            }
        }
        return aux;
    }

    /**
     * Delete an specific node
     * @param data to delete
     * @return if were deleted
     */
    public boolean delete(int data){
        NodeBST aux = root;
        NodeBST dad = root;
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
            if(aux == null){
                return false;
            }
        }
        if(aux.left == null && aux.right == null){
            if(aux == root){
                root = null;
            }else if(child){
                dad.left = null;
            }
            else{
                dad.right = null;
            }
        }else if(aux.right == null){

            if(aux == root){
                root = aux.left;
            }else if(child){
                dad.left = aux.left;
            }
            else{
                dad.right = aux.left;
            }

        }
        else if(aux.left == null){
            if(aux == root){
                root = aux.right;
            }else if(child){
                dad.left = aux.right;
            }
            else{
                dad.right = aux.left;
            }
        }
        else{
            NodeBST substitution = getNodeSub(aux);
            if (aux == root){
                root =  substitution;
            }
            else if(child){
                dad.left = substitution;

            }
            else{
                dad.right = substitution;
            }

            substitution.left = aux.left;

        }
        return true;
    }

    /**
     * Substitution node
     * @param nodeS node to subs
     * @return node subs
     */
    public NodeBST getNodeSub(NodeBST nodeS){
        NodeBST subDad = nodeS;
        NodeBST substitution = nodeS;
        NodeBST aux = nodeS.right;

        while (aux != null){
            subDad = substitution;
            substitution = aux;
            aux = aux.left;
        }

        if(substitution != nodeS.right){
            subDad.left = substitution.right;
            substitution.right = nodeS.right;
        }
        return substitution;

    }

    /**
     * Get tree deep
     * @param node node to start counting
     * @return deep value
     */
    public int getDepth(NodeBST node){
        if (node == null) {
            return (-1);
        } else {
            int leftDepth = getDepth(node.left);
            int rightDepth = getDepth(node.right);
            if (leftDepth > rightDepth )
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }
    
}
