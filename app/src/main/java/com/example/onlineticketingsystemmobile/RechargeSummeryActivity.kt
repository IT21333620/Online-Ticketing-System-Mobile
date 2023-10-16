package com.example.onlineticketingsystemmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RechargeSummeryActivity : AppCompatActivity() {
 
    // Initialize Firebase database reference
    private val database = Firebase.database
    private val myRef = database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge_summery)

        // Retrieve the amount passed from the previous Activity
        val amount = intent.getStringExtra("amount")
        val cardNumber = intent.getStringExtra("cardNumber")
        val expirationDate = intent.getStringExtra("expirationDate")
        val cvv = intent.getStringExtra("cvv")
        val dateTime = intent.getStringExtra("dateTime")

        // display values in a TextView:
        val amountTextView: TextView = findViewById(R.id.balanceTextView)
        amountTextView.text = amount
        val dateTextView: TextView = findViewById(R.id.dateTextView)
        dateTextView.text = dateTime

        val confirmButton: Button = findViewById(R.id.confirmButton)
        confirmButton.setOnClickListener {
            // Create a HashMap to hold the data
            val data = hashMapOf(
                "amount" to amount,
                "cardNumber" to cardNumber,
                "expirationDate" to expirationDate,
                "cvv" to cvv,
                "dateTime" to dateTime
            )

            // Push the data to the Firebase database
            myRef.child("recharge_data").push().setValue(data)
                .addOnSuccessListener {
                    // Data saved successfully
                    Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    // Handle any errors
                    Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
                }
        }
    }
}