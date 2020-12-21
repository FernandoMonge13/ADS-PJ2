package Challenges;

import java.util.Random;

/**
 * @author Marco Rodriguez
 * @version 1.0
 *
 */
public class Generator {
    static Generator Generador;
    private Random rand = new Random();
    private int CurrentChallenge;
    private int CurrentWinCondition;

    /**
     * Singleton
     * @return Estancia siglenton del generador
     */
    public static synchronized Generator obtenerInstancia() {
        if (Generador == null) {
            Generador = new Generator();
        }
        return Generador;
    }

    /**
     * Get para el id del challenge actual
     * @return id actual
     */
    public int getCurrentChallenge() {
        return CurrentChallenge;
    }

    /**
     * Set para el challenge actual
     * @param currentChallenge
     */
    public void setCurrentChallenge(int currentChallenge) {
        CurrentChallenge = currentChallenge;
    }

    /**
     * Get para la win condition actual
     * @return El entero correspondiente a la win condition actual
     */
    public int getCurrentWinCondition() {
        return CurrentWinCondition;
    }

    /**
     * Set para la win condition actual
     * @param currentWinCondition Valor a asignar
     */
    public void setCurrentWinCondition(int currentWinCondition) {
        CurrentWinCondition = currentWinCondition;
    }


    /**
     * Se encarga de generar los valores para los challenges de manera aleatoria
     * Los id`s vienen a ser: 0 BST de profundidad n, 1 AVL con m elementos, 2 B con m niveles, 3 Splay con n elementos
     */
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

    /**
     * Se encarga de limpiar el challenge actual
     */
    public void clearChallenge(){
        this.CurrentChallenge = -1;
        this.CurrentWinCondition = -1;
    }

    /**
     * Checkea si se encuentra un challenge activo
     * @return True de haber challenge activo, false de lo contrario
     */
    public boolean checkIfActiveChallenge(){
        if (this.CurrentWinCondition == -1 && this.CurrentChallenge == -1){
            return false;
        } else {
            return true;
        }
    }
}
