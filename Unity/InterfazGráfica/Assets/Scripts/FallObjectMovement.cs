using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FallObjectMovement : MonoBehaviour
{
    public string type;
    private float lifeTime;

    private void Start()
    {
        lifeTime = 10.0f;
    }

    void Update()
    {
        if (this.type == "rombo")
        {
            this.transform.Translate(Vector3.down * Time.deltaTime);
            this.transform.Translate(Vector3.left * Time.deltaTime);

            this.transform.Rotate(Vector3.right * 50 * Time.deltaTime);
            this.transform.Rotate(Vector3.up * 50 * Time.deltaTime);

        } else if (type == "star")
        {
            this.transform.Translate(Vector3.forward * Time.deltaTime);
            this.transform.Rotate(Vector3.back * 50 * Time.deltaTime);

        } else
        {
            this.transform.Translate(Vector3.down * Time.deltaTime);
            this.transform.Rotate(Vector3.up * 50 * Time.deltaTime);
        }
        lifeTime -= Time.deltaTime;
        if (lifeTime < 0)
        {
            Destroy(this);
        }
    }
}
