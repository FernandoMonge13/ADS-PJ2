package communication;

public class Message {

    public String tree_print;
    public int player;
    public int id;
    public int new_node;
    public int challenge; // id de challenge
    public int winCondition; // cantidad de nodos para ganar
    public boolean win; // si alguien gana
    public boolean checkeo;
    public boolean exit;
    public int winner; // quien gana

    public void setTree_print(String tree_print)
    {
        this.tree_print = tree_print;
    }

    public String getTree_print()
    {
        return this.tree_print;
    }
}
