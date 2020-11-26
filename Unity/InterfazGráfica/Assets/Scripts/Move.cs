using System;
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

    // Moving constants
    private float speed = 10.0f;
    private float jump = 20.0f;
    private float gravity = 9.81f;

    private CharacterController characterController;
    private Vector3 movement = Vector3.zero;

    bool fall;

    private void Start()
    {
        // Components
        rb = this.GetComponent<Rigidbody>();
        animator = this.GetComponent<Animator>();
        transform = this.GetComponent<Transform>();
        lastPosition = transform.position;
        characterController = this.GetComponent<CharacterController>();

        // Dirección de movimiento si es el segundo jugador
        if (player == 1) { speed = -speed; }
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

        // Mueve el jugador
        MoveCharacter();
    }

    private void MoveCharacter()
    {
        movement.y -= gravity * Time.deltaTime;
        characterController.Move(movement * Time.deltaTime);
    }

    void Run()
    {
        if (characterController.isGrounded)
        {
            if (!animator.GetBool("running")) {
                animator.SetBool("running", true);
                animator.SetTrigger("runningT");
            }

            // movement = new Vector3(Input.GetAxis("Horizontal"), 0f, Input.GetAxis("Vertical"));
            movement.x += speed;
        }
    }

    void RunBackwards()
    {
        if (characterController.isGrounded)
        {
            if (!animator.GetBool("backwards")) { 
                animator.SetBool("backwards", true);
                animator.SetTrigger("backwardsT");
            }

            movement.x -= speed;
        }
    }

    void Jump()
    {
        if (inAir || canSecondJump)
        {
            // rb.AddForce(Vector3.up * 3000);

            movement.y = jump;

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

        if (characterController.isGrounded) { movement.y = 0; }
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
            // transform.Translate(Vector3.down * 9.81f * Time.deltaTime);
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
