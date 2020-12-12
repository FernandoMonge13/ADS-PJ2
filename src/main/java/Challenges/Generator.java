package Challenges;

import java.util.Random;

public class Generator {
    static Generator Generador;
    private Random rand = new Random();
    private int CurrentChallenge;
    private int CurrentWinCondition;

    public static synchronized Generator obtenerInstancia() {
        if (Generador == null) {
            Generador = new Generator();
        }
        return Generador;
    }

    public int getCurrentChallenge() {
        return CurrentChallenge;
    }

    public void setCurrentChallenge(int currentChallenge) {
        CurrentChallenge = currentChallenge;
    }

    public int getCurrentWinCondition() {
        return CurrentWinCondition;
    }

    public void setCurrentWinCondition(int currentWinCondition) {
        CurrentWinCondition = currentWinCondition;
    }

    //0 BST de profundidad n, 1 AVL con m elementos, 2 B con m niveles, 3 Splay con n elementos
    public void generateChallenge(){
        int Challenge = rand.nextInt(4);
        this.CurrentChallenge = Challenge;
        if (Challenge == 0) {
            this.CurrentWinCondition = 3 + rand.nextInt(4); // 3 a 6 para ganar
        } else if (Challenge == 1){
            this.CurrentWinCondition = 4 + rand.nextInt(3); // 4 a 6 para ganar
        } else if (Challenge == 2){
            this.CurrentWinCondition = 4 + rand.nextInt(3);// 4 a 6 para ganar
        } else {
            this.CurrentWinCondition = 4 + rand.nextInt(3);// 4 a 6 para ganar
        }
    }

    public void clearChallenge(){
        this.CurrentChallenge = -1;
        this.CurrentWinCondition = -1;
    }

    public boolean checkIfActiveChallenge(){
        if (this.CurrentWinCondition == -1 && this.CurrentChallenge == -1){
            return false;
        } else {
            return true;
        }
    }
}
