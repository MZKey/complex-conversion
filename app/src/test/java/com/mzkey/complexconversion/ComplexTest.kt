package com.mzkey.complexconversion

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class ComplexTest{
	var complexNumber: Complex = Complex()

	@Before
	fun setUp() {
		complexNumber.setArg(90.0)
		complexNumber.setPhi(90.0)
	}

	@Test
	fun getA() {
		assertEquals(0.0,complexNumber.getA(),0.000001)
	}

	@Test
	fun getB() {
		assertEquals(90.0,complexNumber.getB(),0.000001)
	}
}