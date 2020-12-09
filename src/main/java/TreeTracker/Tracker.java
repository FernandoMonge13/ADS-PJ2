package TreeTracker;

import AVLTree.AVLTree;
import BSTree.BinaryTree;
import BSTree.NodeBST;
import BTree.BTree;
import Challenges.Generator;
import SplayTree.SplayTree;

import java.util.Random;

public class Tracker {
    static Tracker tracker;

    private BinaryTree BSTP1 = new BinaryTree();
    private BinaryTree BSTP2= new BinaryTree();

    private AVLTree AVLP1 = new AVLTree();
    private AVLTree AVLP2 = new AVLTree();

    //No se que esta pasando aqui
    private BTree BP1 = new BTree();
    private BTree BP2 = new BTree();

    private SplayTree SplayP1 = new SplayTree();
    private SplayTree SplayP2 = new SplayTree();

    public static synchronized Tracker obtenerInstancia() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public void clearTree(int id, int Player){
        if(id == 0){
            if (Player == 1){
                this.BSTP1 = null;
            } else if (Player == 2){
                this.BSTP2 = null;
            }
        } else if (id == 1) {
            if (Player == 1){
                this.AVLP1 = null;
            } else if (Player == 2){
                this.AVLP2 = null;
            }
        } else if (id == 2) {
            if (Player == 1){
                this.BP1 = null;
            } else if (Player == 2){
                this.BP2 = null;
            }
        } else if (id == 3) {
            if (Player == 1){
                this.SplayP1 = null;
            } else if (Player == 2){
                this.SplayP2 = null;
            }
        }
    }

    public void clearAll(){
        this.BSTP1 = null;
        this.BSTP2 = null;
        this.AVLP1 = null;
        this.AVLP2 = null;
        this.BP1 = null;
        this.BP2 = null;
        this.SplayP1 = null;
        this.SplayP2 = null;
    }


    public void addNode(int Player, int toAdd, int id){
        if(id == 0){
            if (Player == 1){
                BSTP1.insert(toAdd);
            } else if (Player == 2){
                BSTP2.insert(toAdd);
            }
        } else if (id == 1) {
            if (Player == 1){
                AVLP1.insert(toAdd);
            } else if (Player == 2){
                AVLP2.insert(toAdd);
            }
        } else if (id == 2) {
            if (Player == 1){
                BP1.add(toAdd);
            } else if (Player == 2){
                BP2.add(toAdd);
            }
        } else if (id == 3) {
            if (Player == 1){
                SplayP1.insert(toAdd);
            } else if (Player == 2){
                SplayP2.insert(toAdd);
            }
        }
    }

    public BinaryTree getBSTP1() {
        return BSTP1;
    }

    public void setBSTP1(BinaryTree BSTP1) {
        this.BSTP1 = BSTP1;
    }

    public BinaryTree getBSTP2() {
        return BSTP2;
    }

    public void setBSTP2(BinaryTree BSTP2) {
        this.BSTP2 = BSTP2;
    }

    public AVLTree getAVLP1() {
        return AVLP1;
    }

    public void setAVLP1(AVLTree AVLP1) {
        this.AVLP1 = AVLP1;
    }

    public AVLTree getAVLP2() {
        return AVLP2;
    }

    public void setAVLP2(AVLTree AVLP2) {
        this.AVLP2 = AVLP2;
    }

    public BTree getBP1() {
        return BP1;
    }

    public void setBP1(BTree BP1) {
        this.BP1 = BP1;
    }

    public BTree getBP2() {
        return BP2;
    }

    public void setBP2(BTree BP2) {
        this.BP2 = BP2;
    }

    public SplayTree getSplayP1() {
        return SplayP1;
    }

    public void setSplayP1(SplayTree splayP1) {
        SplayP1 = splayP1;
    }

    public SplayTree getSplayP2() {
        return SplayP2;
    }

    public void setSplayP2(SplayTree splayP2) {
        SplayP2 = splayP2;
    }
}
