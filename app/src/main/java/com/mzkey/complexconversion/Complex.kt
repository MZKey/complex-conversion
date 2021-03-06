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

	fun getA(): Double = this.a
	fun getB(): Double = this.b
	fun getArg(): Double = this.arg
	fun getPhi(): Double = this.phi


	private fun convertFromExpToAlg() {
		this.a = (arg * cos(phi * (PI / 180.0)))
		this.b = (arg * sin(phi * (PI / 180.0)))
	}

	private fun convertFromAlgToExp() {
		this.arg = sqrt((this.a * this.a) + (this.b * this.b))

		if (this.a > 0) this.phi =
			atan(abs((this.b * (PI / 180.0)) / (this.a * (PI / 180.0)))) * (180.0 / PI)
		else if (this.a < 0 && this.b > 0) this.phi =
			atan(abs((this.b * (PI / 180.0)) / (this.a * (PI / 180.0)))) * (180.0 / PI) + 180.0
		else if (this.a < 0 && this.b < 0) this.phi =
			atan(abs((this.b * (PI / 180.0)) / (this.a * (PI / 180.0)))) * (180.0 / PI) - 180.0
		else if (this.a == 0.0 && this.b > 0) this.phi = 90.0
		else if (this.a == 0.0 && this.b < 0) this.phi = -90.0
		else if (this.a == 0.0 && this.b == 0.0) this.phi = 0.0
	}

	operator fun plus(other: Complex): Complex {
		val rv: Complex = Complex()
		rv.a = this.a + other.a
		rv.b = this.b + other.b
		return rv
	}

	operator fun minus(other: Complex): Complex {
		val rv: Complex = Complex()
		rv.a = this.a - other.a
		rv.b = this.b - other.b
		return rv
	}

	operator fun div(other: Complex): Complex {
		val rv: Complex = Complex()
		rv.arg = this.arg / other.arg
		rv.phi = this.phi - other.phi
		return rv
	}

	// times - mul
	operator fun times(other: Complex): Complex {
		val rv: Complex = Complex()
		rv.arg = this.arg * other.arg
		rv.phi = this.phi + other.phi
		return rv
	}
}