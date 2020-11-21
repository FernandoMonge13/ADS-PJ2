using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spawner : MonoBehaviour
{
    public Transform spawnTransform;
    public GameObject spawnObject;

    void Update()
    {
        if (Input.GetMouseButton(0))
        {
            Instantiate(spawnObject, spawnTransform.position, spawnTransform.rotation);
        }
    }
}
