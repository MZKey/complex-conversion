package com.mzkey.complexconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var atext: String
        var btext: String
        var a: Double
        var b: Double
        var arg: Double
        var phi: Double
        var res: String
        var signsAfterDot: Int = 3

        buttonCalculate.setOnClickListener()
        {
            if (editTextArg.text.isNotEmpty() && editTextPhi.text.isNotEmpty()) {
                arg = editTextArg.text.toString().toDouble()
                phi = editTextPhi.text.toString().toDouble()
                a = (arg * cos(phi * (PI / 180)))
                b = (arg * sin(phi * (PI / 180)))
                atext = String.format("%.${signsAfterDot}f", a)
                btext = String.format("%.${signsAfterDot}f", b)
                res = if (b >= 0)
                    atext + "+" + btext + "i"
                else
                    atext + btext + "i"
                textViewRes.text = res
            } else textViewRes.text = "Fill the fields"
        }
    }
}
