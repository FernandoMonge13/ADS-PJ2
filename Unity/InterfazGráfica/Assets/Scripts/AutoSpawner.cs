using System.Collections;
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
        remainingTime = Random.Range(0.5f, 1.0f);
    }

    void Update()
    {
        
        if (remainingTime < 0)
        {
            int ran = Random.Range(0, 110);
            if (ran > 99)
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
            Instantiate(gameObject, gameObject.transform.position, gameObject.transform.rotation);
            remainingTime = Random.Range(0.5f, 1.0f);
        }
        remainingTime -= Time.deltaTime;
    }
}
