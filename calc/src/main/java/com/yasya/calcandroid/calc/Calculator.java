package com.yasya.calcandroid.calc;

public class Calculator {
	public int sum(int a, int b) {
		return a + b;
	}

	public int devide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException(
					"You just divided by zero, didn't you?");
		} else {
			return a / b;
		}
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public int mult(int a, int b) {
		return a * b;
	}
}
