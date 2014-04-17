package com.yasya.calcandroid.calc.test.unittest;

import android.test.suitebuilder.annotation.SmallTest;

import com.yasya.calcandroid.calc.Calculator;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
	Calculator calk = new Calculator();

	protected void setUp() throws Exception {

	}
    @SmallTest
	public void testSum() {
		int res = calk.sum(5, 5);
		assertEquals(10, res);
	}
    @SmallTest
	public void testMinus() {
		int res = calk.minus(15, 5);
		assertEquals(10, res);
	}
    @SmallTest
	public void testMult() {
		int res = calk.mult(2, 5);
		assertEquals(10, res);
	}
    @SmallTest
	public void testDiv() {
		int res = calk.devide(20, 2);
		assertEquals(10, res);
	}
    @SmallTest
	public void testDivZero() {
		try {
			calk.devide(10, 0);
			fail("Missing exception");
		} catch (ArithmeticException ex) {
			assertEquals("You just divided by zero, didn't you?",
					ex.getMessage());
		}
	}
}
