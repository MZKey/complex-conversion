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
				complexNumber.arg = editTextArg.text.toString().toDouble()
				complexNumber.phi = editTextPhi.text.toString().toDouble()
				atext = String.format("%.${signsAfterDot}f", complexNumber.a)
				btext = String.format("%.${signsAfterDot}f", complexNumber.b)
				res = if (complexNumber.b >= 0)
					atext + "+" + btext + "i"
				else
					atext + btext + "i"
				textViewAlgRes.text = res
			} else textViewAlgRes.text = "Fill the fields"
		}

		buttonCalculateExp.setOnClickListener() {
			if (editTextA.text.isNotEmpty() && editTextB.text.isNotEmpty()) {
				complexNumber.a = editTextA.text.toString().toDouble()
				complexNumber.b = editTextB.text.toString().toDouble()
				textViewResArg.text =
					"arg: +${String.format("%.${signsAfterDot}f", complexNumber.arg)}"
				textViewResPhi.text =
					"phi: +${String.format("%.${signsAfterDot}f", complexNumber.arg)}"
			} else {
				textViewResArg.text = "Fill the fields"
				textViewResPhi.text = ""
			}
		}
	}
}
