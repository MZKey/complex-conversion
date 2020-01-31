package com.mzkey.complexconversion

import kotlin.math.*

class Complex {
	private var a: Double = 0.0
	private var b: Double = 0.0
	private var arg: Double = 0.0
	private var phi: Double = 0.0

	fun setA(a: Double) {
		this.a = a
		convertFromAlgToExp()
	}

	fun setB(b: Double) {
		this.b = b
		convertFromAlgToExp()
	}

	fun setArg(arg: Double) {
		this.arg = arg
		convertFromExpToAlg()
	}

	fun setPhi(phi: Double) {
		this.phi = phi
		convertFromExpToAlg()
	}

	fun getA(): Double {
		return a
	}

	fun getB(): Double {
		return b
	}

	fun getArg(): Double {
		return arg
	}

	fun getPhi(): Double {
		return phi
	}

	private fun convertFromExpToAlg() {
		this.a = (arg * cos(phi * (PI / 180)))
		this.b = (arg * sin(phi * (PI / 180)))
	}

	private fun convertFromAlgToExp() {
		this.arg = sqrt((this.a * this.a) + (this.b * this.b))

		if (this.a > 0) this.phi = atan(abs(this.b / this.a))
		else if (this.a < 0 && this.b > 0) this.phi = atan(abs(this.b / this.a)) + 180.0
		else if (this.a < 0 && this.b < 0) this.phi = atan(abs(this.b / this.a)) - 180.0
		else if (this.a == 0.0 && this.b > 0) this.phi = 90.0
		else if (this.a == 0.0 && this.b < 0) this.phi = -90.0
	}
}