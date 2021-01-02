package com.shivtej.cashregister

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CashViewActivity : AppCompatActivity() {

    lateinit var twoThousand: TextView
    lateinit var fiveHundred: TextView
    lateinit var twoHundred: TextView
    lateinit var hundred: TextView
    lateinit var fifty: TextView
    lateinit var twenty: TextView
    lateinit var ten: TextView
    lateinit var five: TextView
    lateinit var two: TextView
    lateinit var one: TextView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_view)

        twoThousand = findViewById(R.id.twoThousand)
        fiveHundred = findViewById(R.id.fiveHundred)
        hundred = findViewById(R.id.hundred)
        twoHundred = findViewById(R.id.twoHundred)
        fifty = findViewById(R.id.fifty)
        twenty = findViewById(R.id.twenty)
        ten = findViewById(R.id.ten)
        five = findViewById(R.id.five)
        two = findViewById(R.id.two)
        one = findViewById(R.id.one)

        val amountTextView: TextView = findViewById(R.id.amount)


        val intent = intent
        val amount = intent.getIntExtra("Amount", 0)
        val cash = calculate(amount)
        amountTextView.text = amountTextView.text.toString() + amount


        twoThousand.text = cash.a.toString()
        fiveHundred.text = cash.b.toString()
        twoHundred.text = cash.c.toString()
        hundred.text = cash.d.toString()
        fifty.text = cash.e.toString()
        twenty.text = cash.f.toString()
        ten.text = cash.g.toString()
        five.text = cash.h.toString()
        two.text = cash.i.toString()
        one.text = cash.j.toString()
        if (cash.a.toString() != "0") {
            twoThousand.setTypeface(null, Typeface.BOLD)
        }
        if (cash.b.toString() != "0") {
            fiveHundred.setTypeface(null, Typeface.BOLD)
        }
        if (cash.c.toString() != "0") {
            twoHundred.setTypeface(null, Typeface.BOLD)
        }
        if (cash.d.toString() != "0") {
            hundred.setTypeface(null, Typeface.BOLD)
        }
        if (cash.e.toString() != "0") {
            fifty.setTypeface(null, Typeface.BOLD)
        }
        if (cash.f.toString() != "0") {
            twenty.setTypeface(null, Typeface.BOLD)
        }
        if (cash.g.toString() != "0") {
            ten.setTypeface(null, Typeface.BOLD)
        }
        if (cash.h.toString() != "0") {
            five.setTypeface(null, Typeface.BOLD)
        }
        if (cash.i.toString() != "0") {
            two.setTypeface(null, Typeface.BOLD)
        }
        if (cash.j.toString() != "0") {
            one.setTypeface(null, Typeface.BOLD)
        }


    }

    private fun calculate(amount: Int): ReturnCash {
        var twoThousand = 0
        var fiveHundred = 0
        var twoHundred = 0
        var hundred = 0
        var fifty = 0
        var twenty = 0
        var ten = 0
        var five = 0
        var two = 0
        var one = 0

        var n = amount
        while (n > 0) {
            when {
                n >= 2000 -> {
                    twoThousand += 1
                    n = n - 2000
                }
                n >= 500 -> {
                    fiveHundred += 1
                    n = n - 500
                }
                n >= 200 -> {
                    twoHundred = twoHundred + 1
                    n = n - 200
                }
                n >= 100 -> {
                    hundred = hundred + 1
                    n = n - 100
                }
                n >= 50 -> {
                    fifty = fifty + 1
                    n = n - 50
                }
                n >= 20 -> {
                    twenty = twenty + 1
                    n = n - 20
                }
                n >= 10 -> {
                    ten = ten + 1
                    n = n - 10
                }
                n >= 5 -> {
                    five = five + 1
                    n = n - 5
                }
                n >= 2 -> {
                    two = two + 1
                    n = n - 2
                }
                n >= 1 -> {
                    one = one + 1
                    n = n - 1
                }
                else -> {
                    print("Sorry")

                }
            }
        }

        val returnCash = ReturnCash(
            twoThousand,
            fiveHundred,
            twoHundred,
            hundred,
            fifty,
            twenty,
            ten,
            five,
            two,
            one
        )

        return returnCash

    }
}