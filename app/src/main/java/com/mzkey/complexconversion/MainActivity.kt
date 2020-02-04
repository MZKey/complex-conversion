package com.mzkey.complexconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		var complexNumber = Complex()
		var res: String
		var signsAfterDot = 3
		var atext: String
		var btext: String

		buttonCalculateAlg.setOnClickListener() {
			if (editTextArg.text.isNotEmpty() && editTextPhi.text.isNotEmpty()) {
				complexNumber.setArg(editTextArg.text.toString().toDouble())
				complexNumber.setPhi(editTextPhi.text.toString().toDouble())
				atext = String.format("%.${signsAfterDot}f", complexNumber.getA())
				btext = String.format("%.${signsAfterDot}f", complexNumber.getB())
				res = if (complexNumber.getB() >= 0)
					atext + "+" + btext + "i"
				else
					atext + btext + "i"
				textViewAlgRes.text = res
			} else textViewAlgRes.text = "Fill the fields"
		}

		buttonCalculateExp.setOnClickListener() {
			if (editTextA.text.isNotEmpty() && editTextB.text.isNotEmpty()) {
				complexNumber.setA(editTextA.text.toString().toDouble())
				complexNumber.setB(editTextB.text.toString().toDouble())
				textViewResArg.text =
					"arg: ${String.format("%.${signsAfterDot}f", complexNumber.getArg())}"
				textViewResPhi.text =
					"phi: ${String.format("%.${signsAfterDot}f", complexNumber.getPhi())}"
			} else {
				textViewResArg.text = "Fill the fields"
				textViewResPhi.text = ""
			}
		}
	}
}
