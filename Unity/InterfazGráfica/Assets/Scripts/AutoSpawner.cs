﻿using System.Collections;
using UnityEngine;

public class AutoSpawner : MonoBehaviour
{
    public GameObject star;
    public GameObject sphere;
    public GameObject rombo;
    public GameObject square;
    private GameObject gameObject;
    private float remainingTime;

    private void Start()
    {
        remainingTime = Random.Range(1.5f, 3.5f);
    }

    void Update()
    {

        remainingTime -= Time.deltaTime;
        
        if (remainingTime < 0)
        {
            int ran = Random.Range(0, 110);
            if (ran > 107)
            {
                gameObject = star;
            } else if (0 < ran && ran < 33) 
            {
                gameObject = sphere;
            } else if (33 < ran && ran < 66)
            {
                gameObject = rombo;
            } else
            {
                gameObject = square;
            }
            Vector3 position = new Vector3(Random.Range(-3.5f, 3.5f), 5, 5);
            Instantiate(gameObject, position, gameObject.transform.rotation);
            remainingTime = Random.Range(1.5f, 4.5f);
        }
    }
}
