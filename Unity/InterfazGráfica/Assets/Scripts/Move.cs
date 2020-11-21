using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Move : MonoBehaviour
{
    // public Transform transform;
    // public GameObject gameObject;
    bool jumping;


    private void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey(KeyCode.A)) {
            this.transform.Translate(Vector3.left * Time.deltaTime);
        }
        if (Input.GetKey(KeyCode.D)) {
            this.transform.Translate(Vector3.right * Time.deltaTime);
        }
        if (Input.GetKey(KeyCode.W)) {
            Jump();
        }
    }

    void Jump()
    {
        this.transform.Translate(Vector3.up * Time.deltaTime);
    }
}
