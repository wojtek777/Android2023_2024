package com.example.zadanie09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.zadanie09.models.CardPaymentRequest
import com.example.zadanie09.models.CardPaymentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentFormActivity : AppCompatActivity()
{
    lateinit var etCardNumber: EditText
    lateinit var etExpirationDate: EditText
    lateinit var etCVV: EditText
    lateinit var bPerformPayment: Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_form)

        etCardNumber = findViewById(R.id.etCardNumber)
        etExpirationDate = findViewById(R.id.etExpirationDate)
        etCVV = findViewById(R.id.etCVV)
        bPerformPayment = findViewById(R.id.bPerformPayment)

        bPerformPayment.setOnClickListener {
            performPayment(it)
        }
    }

    private fun performPayment(view: View)
    {
        val cardNumber = etCardNumber.text.toString()
        val expirationDate = etExpirationDate.text.toString()
        val cvv = etCVV.text.toString()

        if (verifyCardNumber(cardNumber) && verifyExpirationDate(expirationDate) && verifyCVV(cvv))
        {
            val request = CardPaymentRequest(cardNumber, expirationDate, cvv)
            val call = RetrofitInstance.api.performCardPayment(request)

            call.enqueue(object: Callback<CardPaymentResponse>
            {
                override fun onResponse(call: Call<CardPaymentResponse>, response: Response<CardPaymentResponse>)
                {
                    val loginResponse = response.body()
                    if (loginResponse!!.paymentResult)
                    {
                        Toast.makeText(this@PaymentFormActivity, "Transaction completed", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(this@PaymentFormActivity, "Transaction did not succeeded ", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<CardPaymentResponse>, t: Throwable)
                {
                    Toast.makeText(this@PaymentFormActivity, "Error during connection", Toast.LENGTH_SHORT).show()
                }
            })
        }
        else
        {
            Toast.makeText(this, "Check if provided data is valid", Toast.LENGTH_SHORT)
        }
    }

    private fun verifyCardNumber(cardNumber: String): Boolean
    {
        return true
    }

    private fun verifyExpirationDate(expirationDate: String): Boolean
    {   
        return true
    }

    private fun verifyCVV(cvv: String): Boolean
    {
        return true
    }
}
