using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Move : MonoBehaviour
{
    // public Transform transform;
    // public GameObject gameObject;
    public bool isGrounded;
    public int pj;
    private Rigidbody rb;

    private void Start()
    {
        rb = this.GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void Update()
    {
        if (pj == 0)
        {
            if (Input.GetKey(KeyCode.A))
            {
                this.transform.Translate(Vector3.left * 4 * Time.deltaTime);
            }
            if (Input.GetKey(KeyCode.D))
            {
                this.transform.Translate(Vector3.right * 4 * Time.deltaTime);
            }
            if (Input.GetKey(KeyCode.W))
            {
                Jump();
            }
        } else if (pj == 1)
        {
            if (Input.GetKey(KeyCode.J))
            {
                this.transform.Translate(Vector3.left * Time.deltaTime);
            }
            if (Input.GetKey(KeyCode.L))
            {
                this.transform.Translate(Vector3.right * Time.deltaTime);
            }
            if (Input.GetKey(KeyCode.I))
            {
                Jump();
            }
        }
        this.transform.rotation = new Quaternion(0, 0, 0, 0);
    }

    void Jump()
    {
        Debug.Log("SALTANDO");
        this.GetComponent<Rigidbody>().AddForce(Vector3.up * 7);
        
    }

    void OnCollisionEnter(Collision other)
    {
        if (other.gameObject.tag == "Ground")
        {
            isGrounded = true;
        }
    }

    void OnCollisionExit(Collision other)
    {
        if (other.gameObject.tag == "Ground")
        {
            isGrounded = false;
        }
    }
}
