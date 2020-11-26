using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour
{
    public CharacterController controller;
    public Animator animator;

    public float speed = 12f;
    public float gravity = -9.81f;
    public float jumpHeight = 3f;

    public Transform groundCheck;
    public float groundDistance = 0.4f;
    public LayerMask groundMask;

    Vector3 velocity;
    bool isGrounded;

    public int player;
    public int direction;

    private float xMove;
    private float zMove;

    // Start is called before the first frame update
    void Start()
    {
        if (player == 0)
        {
            direction = 1;
        } else if (player == 1)
        {
            direction = -1;
        }
    }

    // Update is called once per frame
    void Update()
    {
        
        if (player == 0)
        {
            if (Input.GetKey(KeyCode.D)) { Run(); }
            else if (Input.GetKey(KeyCode.A)) { RunBackwards(); }
            if (Input.GetKeyDown(KeyCode.W)) { Jump(); }
        }
        else if (player == 1)
        {
            if (Input.GetKey(KeyCode.J)) { Run(); }
            else if (Input.GetKey(KeyCode.L)) { RunBackwards(); }
            if (Input.GetKeyDown(KeyCode.I)) { Jump(); }
        }
    }

    void Run()
    {
        if (!animator.GetBool("running") && isGrounded)
        {
            animator.SetBool("running", true);
            animator.SetTrigger("runningT");
        }
        controller.Move((transform.forward * direction) * speed * Time.deltaTime);
    }

    void RunBackwards()
    {
        if (!animator.GetBool("backwards") && isGrounded)
        {
            animator.SetBool("backwards", true);
            animator.SetTrigger("backwardsT");
        }
        controller.Move((transform.forward * -direction) * speed * Time.deltaTime);
    }

    void Jump()
    {
        
        velocity.y = Mathf.Sqrt(jumpHeight * -2f * gravity);

        velocity.y += gravity * Time.deltaTime;

        controller.Move(velocity * Time.deltaTime);
    }

    void GroundedCheck()
    {
        isGrounded = Physics.CheckSphere(groundCheck.position, groundDistance, groundMask);

        if (isGrounded && velocity.y < 0)
        {
            velocity.y = -2f;
        }
    }
}
