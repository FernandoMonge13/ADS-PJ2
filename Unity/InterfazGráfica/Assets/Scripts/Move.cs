using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Move : MonoBehaviour
{
    private Transform transform;
    
    public int player;
    private Rigidbody rb;
    private Animator animator;

    // Moving
    private Vector3 lastPosition;
    private float zSpeed;
    private bool inAir;
    private bool canSecondJump;

    bool fall;

    private void Start()
    {
        rb = this.GetComponent<Rigidbody>();
        animator = this.GetComponent<Animator>();
        transform = this.GetComponent<Transform>();
        lastPosition = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        ResetTriggers();
        Land();

        if (player == 0)
        {
            if (Input.GetKeyDown(KeyCode.W)) { Jump(); }
            else if (Input.GetKey(KeyCode.D)) { Run(); }
            else if (Input.GetKey(KeyCode.A)) { RunBackwards(); }
            else { NotMoving(); }
        }
        else if (player == 1)
        {
            if (Input.GetKeyDown(KeyCode.I)) { Jump(); }
            else if (Input.GetKey(KeyCode.J)) { Run(); }
            else if (Input.GetKey(KeyCode.L)) { RunBackwards(); }
            else { NotMoving(); }
        }

        CheckInAir();
        
    }

    void Run()
    {
        if (!inAir)
        {
            if (!animator.GetBool("running")) {
                Debug.Log("asd");
                animator.SetBool("running", true);
                animator.SetTrigger("runningT");
            }

            transform.Translate(Vector3.forward * 4 * Time.deltaTime);
        }
    }

    void RunBackwards()
    {
        if (!inAir)
        {
            if (!animator.GetBool("backwards")) { 
                animator.SetBool("backwards", true);
                animator.SetTrigger("backwardsT");
            }

            transform.Translate(Vector3.back * Time.deltaTime);
        }
    }

    void Jump()
    {
        if (inAir || canSecondJump)
        {
            rb.AddForce(Vector3.up * 3000);
            inAir = false;
            animator.SetBool("inAir", true);
            animator.SetTrigger("jump");

            if (!inAir) { canSecondJump = false; }
        }
    }

    void NotMoving()
    {
        if (animator.GetBool("running")) { animator.SetBool("running", false); }
        if (animator.GetBool("backwards")) { animator.SetBool("backwards", false); }
    }

    void ResetTriggers()
    {
        animator.ResetTrigger("jump");
    }

    void CheckInAir()
    {
        zSpeed = (transform.position.z - lastPosition.z) / Time.deltaTime;
        lastPosition = transform.position;

        inAir = (zSpeed > 3f || zSpeed < -3f);
        if (!inAir)
        {
            canSecondJump = true;
            animator.SetBool("inAir", false);
        }
    }

    void Land()
    {
        if (fall)
        {
            transform.Translate(Vector3.down * 9.81f * Time.deltaTime);
        }
    }

    private void OnCollisionExit(Collision other)
    {
        if (other.gameObject.tag == "Ground")
        {
            fall = true;
        }
    }

    void OnCollisionEnter(Collision other)
    {
        if (other.gameObject.tag == "Ground")
        {
            fall = true;
        }
    }
}
