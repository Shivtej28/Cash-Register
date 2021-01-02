package com.shivtej.cashregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

     lateinit var billAmount: EditText
    lateinit var cashGiven: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billAmount = findViewById(R.id.billAmount)
        cashGiven = findViewById(R.id.cashGiven)

    }

    fun enter(view: View) {
        var x: Int = cashGiven.text.toString().toInt()
        var y: Int = billAmount.text.toString().toInt()
        var amount: Int = x.minus(y)
        Log.i("Amount", amount.toString())
        val intent = Intent(this, CashViewActivity::class.java)
        intent.putExtra("Amount", amount)
        startActivity(intent)
        //Log.i("Cash", "($a, $b, $c, $d, $e, $f, $g, $h, $i, $j)")
    }


}


