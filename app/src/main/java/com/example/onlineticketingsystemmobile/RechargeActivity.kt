package com.example.onlineticketingsystemmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar

class RechargeActivity : AppCompatActivity() {

    private lateinit var amountEditText: EditText
    private lateinit var cardNumberEditText: EditText
    private lateinit var expirationDateEditText: EditText
    private lateinit var cvvEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge)

        // Initialize the EditText fields
        amountEditText = findViewById(R.id.amountEditText)
        cardNumberEditText = findViewById(R.id.cardNumberEditText)
        expirationDateEditText = findViewById(R.id.expirationDateEditText)
        cvvEditText = findViewById(R.id.cvvEditText)

        val payButton: Button = findViewById(R.id.payButton)

        payButton.setOnClickListener {
            // Get the entered values
            val amount = amountEditText.text.toString()
            val cardNumber = cardNumberEditText.text.toString()
            val expirationDate = expirationDateEditText.text.toString()
            val cvv = cvvEditText.text.toString()

            // Get current date and time
            val calendar = Calendar.getInstance()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val dateTime = dateFormat.format(calendar.time)

            // save these values using storage mechanism
            // Example using SharedPreferences:
            val sharedPreferences = getSharedPreferences("PayDetails", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("amount", amount)
            editor.putString("cardNumber", cardNumber)
            editor.putString("expirationDate", expirationDate)
            editor.putString("cvv", cvv)
            editor.putString("dateTime", dateTime) // Save date and time
            editor.apply()

            // Create an Intent to start RechargeSummaryActivity
            val intent = Intent(this, RechargeSummeryActivity::class.java)

            // Pass the amount to the RechargeSummaryActivity
            intent.putExtra("amount", amount)
            intent.putExtra("cardNumber", cardNumber)
            intent.putExtra("expirationDate", expirationDate)
            intent.putExtra("cvv", cvv)
            intent.putExtra("dateTime", dateTime)

            // Start the new Activity
            startActivity(intent)
        }
    }
}
