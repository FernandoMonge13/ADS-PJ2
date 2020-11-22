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

    private int selectedMat;
    private bool selectedMatBool = false;

    public void Start()
    {
        cajaTexto.SetActive(false);
    }

    public void NextL()
    {
        if (selectedMat == 0 && !selectedMatBool)
        {
            selectedMat = 0;
            selectedMatBool = true;
        }
        else {
            selectedMat += 1;
            if (selectedMat > 5) { selectedMat = 0; }
        }
        CambiarColor(selectedMat, 0);
    }

    public void NextR()
    {
        if (selectedMat == 0 && !selectedMatBool)
        {
            selectedMat = 0;
            selectedMatBool = true;
        }
        else
        {
            selectedMat += 1;
            if (selectedMat > 5) { selectedMat = 0; }
        }
        CambiarColor(selectedMat, 1);
    }

    public void PrevL()
    {
        if (selectedMat == 0 && !selectedMatBool)
        {
            selectedMat = 5;
            selectedMatBool = true;
        }
        else
        {
            selectedMat -= 1;
            if (selectedMat < 0) { selectedMat = 5; }
        }
        CambiarColor(selectedMat, 0);
    }

    public void PrevR()
    {
        if (selectedMat == 0 && !selectedMatBool)
        {
            selectedMat = 5;
            selectedMatBool = true;
        }
        else
        {
            selectedMat -= 1;
            if (selectedMat < 0) { selectedMat = 5; }
        }
        CambiarColor(selectedMat, 1);
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
            Debug.Log(player1.GetComponent<MeshRenderer>().material == material);
        } else
        {
            player2.GetComponent<MeshRenderer>().material = material;
        }
    }

    public void Jugar()
    {
        if (player1.GetComponent<MeshRenderer>().material == player2.GetComponent<MeshRenderer>().material)
        {
            cajaTexto.SetActive(true);
        } else
        {
            cajaTexto.SetActive(false);
            SceneManager.LoadScene(0);
        }
    }
}
