package com.durgaprasad.calculator

import android.location.GnssAntennaInfo
import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var result : EditText
    private lateinit var newNumber : EditText
    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.operation)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button0: Button = findViewById(R.id.button0)
        var button1: Button = findViewById(R.id.button1)
        var button2: Button = findViewById(R.id.button2)
        var button3: Button = findViewById(R.id.button3)
        var button4: Button = findViewById(R.id.button4)
        var button5: Button = findViewById(R.id.button5)
        var button6: Button = findViewById(R.id.button6)
        var button7: Button = findViewById(R.id.button7)
        var button8: Button = findViewById(R.id.button8)
        var button9: Button = findViewById(R.id.button9)

        var buttonDot: Button = findViewById(R.id.buttonDecimal)
        var buttonEquals: Button = findViewById(R.id.buttonEquals)
        var buttonPlus: Button = findViewById(R.id.buttonPlus)
        var buttonMinus: Button = findViewById(R.id.buttonMinus)
        var buttonMultiply: Button = findViewById(R.id.buttonMulti)
        var buttonDivide: Button = findViewById(R.id.buttonDivide)

        result = findViewById(R.id.result)
        newNumber = findViewById(R.id.newNumber)

        val listener = View.OnClickListener { v ->
            val b = v as Button
            newNumber.append(b.text)
        }

        val opListener = View.OnClickListener { v->
            val op = (v as Button).text.toString()
            val value = newNumber.text.toString()
            if (value.isNotEmpty()){
                calculate(value,op)
            }
        }
        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonEquals.setOnClickListener(opListener)
    }
    private fun calculate(value:String,operator:String){
        displayOperation.text = operator
    }
}


