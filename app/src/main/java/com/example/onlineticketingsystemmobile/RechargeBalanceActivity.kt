package com.example.onlineticketingsystemmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RechargeBalanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge_balance)

        val payButton: Button = findViewById(R.id.payButton)

        payButton.setOnClickListener {
            // When the "Recharge" button is clicked, navigate to the RechargeActivity
            val intent = Intent(this, RechargeActivity::class.java)
            startActivity(intent)
        }
    }
}
