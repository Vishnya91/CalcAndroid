package com.yasya.calcandroid.calc.test.testrunner;

import com.yasya.calcandroid.calc.test.test.CalculatorActivityTest;
import com.yasya.calcandroid.calc.test.unittest.CalculatorTest;

import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

public class MyInstrumentationTestRunner extends InstrumentationTestRunner {
	@Override
	public TestSuite getAllTests(){
		InstrumentationTestSuite suite = new InstrumentationTestSuite(this);
		
		suite.addTestSuite(CalculatorTest.class);
		suite.addTestSuite(CalculatorActivityTest.class);
		return suite;
	}
	@Override
	public ClassLoader getLoader(){
		return MyInstrumentationTestRunner.class.getClassLoader();
	}
}
