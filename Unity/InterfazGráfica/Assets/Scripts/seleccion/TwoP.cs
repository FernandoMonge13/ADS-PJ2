using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class TwoP : MonoBehaviour
{
    public Material red;
    public Material blue;
    public Material green;
    public Material orange;
    public Material yellow;
    public Material purple;

    public GameObject player1;
    public GameObject player2;

    public GameObject cajaTexto;

    private int[] playersMat = {-1,-1};

    public void Start()
    {
        cajaTexto.SetActive(false);
    }

    public void NextL()
    {
        if (playersMat[0] == -1)
        {
            playersMat[0] = 0;
        }
        else {
            playersMat[0] += 1;
            if (playersMat[0] > 5) { playersMat[0] = 0; }
        }
        CambiarColor(playersMat[0], 0);
    }

    public void NextR()
    {
        if (playersMat[1] == -1)
        {
            playersMat[1] = 0;
        }
        else
        {
            playersMat[1] += 1;
            if (playersMat[1] > 5) { playersMat[1] = 0; }
        }
        CambiarColor(playersMat[1], 1);
    }

    public void PrevL()
    {
        if (playersMat[0] == -1)
        {
            playersMat[0] = 5;
        }
        else
        {
            playersMat[0] -= 1;
            if (playersMat[0] < 0) { playersMat[0] = 5; }
        }
        CambiarColor(playersMat[0], 0);
    }

    public void PrevR()
    {
        if (playersMat[1] == -1)
        {
            playersMat[1] = 5;
        }
        else
        {
            playersMat[1] -= 1;
            if (playersMat[1] < 0) { playersMat[1] = 5; }
        }
        this.CambiarColor(playersMat[1], 1);
    }

    private void CambiarColor(int i, int j)
    {
        switch (i) {
            case 0:
                ChangeColour(j, red);
                break;
            case 1:
                ChangeColour(j, blue);
                break;
            case 2:
                ChangeColour(j, green);
                break;
            case 3:
                ChangeColour(j, orange);
                break;
            case 4:
                ChangeColour(j, yellow);
                break;
            case 5:
                ChangeColour(j, purple);
                break;
        }
    }

    private void ChangeColour(int j, Material material)
    {
        if (j == 0)
        {
            player1.GetComponent<MeshRenderer>().material = material;
        } else
        {
            player2.GetComponent<MeshRenderer>().material = material;
        }
    }

    public void Jugar()
    {
        Debug.Log("Valores del array " + playersMat[0] + playersMat[1]);
        if (playersMat[0] == playersMat[1])
        {
            cajaTexto.SetActive(true);
        } else
        {
            cajaTexto.SetActive(false);
            SceneManager.LoadScene(0);
        }
    }
}
