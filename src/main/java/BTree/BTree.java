package BTree;
import java.util.Stack;

public class BTree {
    private int T;

    public class NodeB{
        int n;
        int key[] = new int[2*T-1];
        NodeB child[] = new NodeB[2 * T];
        boolean leaf = true;

        public int Find(int k){
            for (int i = 0; i < this.n; i++){
                if (this.key[i] == k){
                    return i;
                }
            }
            return -1;
        }
    }

    public BTree (int t){
        T = t;
        root = new NodeB();
        root.n = 0;
        root.leaf = true;
    }

    private NodeB root;

    // Search the key
    private NodeB search(NodeB x, int key){
        int i = 0;
        if (x == null){
            return x;
        }
        for (i = 0; i < x.n; i++){
            if (key < x.key[i]){
                break;
            }
            if (key == x.key[i]){
                return x;
            }
        }
        if (x.leaf){
            return null;
        }
        else{
            return search(x.child[i], key);
        }
    }

    //Split function
    private void split(NodeB x, int pos, NodeB y){
        NodeB z = new NodeB();
        z.leaf = y.leaf;
        z.n = T - 1;

        if (!y.leaf){
            for (int j = 0; j < T; j++){
                z.child[j] = y.child[j +T];
            }
        }

        y.n = T - 1;

        for (int j = x.n; j >= pos; j--){
            x.child[j+1] = x.child[j];
        }

        x.child[pos + 1] = z;

       for (int j = x.n -1; j >= pos; j--){
           x.key[j+1] = x.key[j];
       }
       x.key[pos] = y.key[T - 1];
       x.n = x.n + 1;
    }


}
