package com.yasya.calcandroid.calc.test.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.EditText;

import com.robotium.solo.Solo;
import com.yasya.calcandroid.calc.CalculatorActivity;
import com.yasya.calcandroid.calc.R;

public class CalculatorActivityTest extends
        ActivityInstrumentationTestCase2<CalculatorActivity> {
    private static Solo solo;

    public CalculatorActivityTest() {
        super(CalculatorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    protected static void tearDownAfterClass() throws Exception {
        //solo.finishOpenedActivities();
    }

    @SmallTest
    protected void tearDown() throws Exception {
        /*EditText FirsteditText = (EditText) solo.getView(R.id.editText1);
		solo.clearEditText(FirsteditText);*/
        solo.finishOpenedActivities();
    }

    @SmallTest
    public void testDisplayWhiteBox_sum() {

        int firstNumber = 10;
        int secondNumber = 20;
        int result = firstNumber + secondNumber;

        EditText FirsteditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(FirsteditText, String.valueOf(firstNumber));

        solo.clickOnButton("+");

        EditText SecondeditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(SecondeditText, String.valueOf(secondNumber));

        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    public void testDisplayWhiteBox_minus() {

        int firstNumber = 20;
        int secondNumber = 10;
        int result = firstNumber - secondNumber;

        EditText FirsteditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(FirsteditText, String.valueOf(firstNumber));

        solo.clickOnButton("-");

        EditText SecondeditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(SecondeditText, String.valueOf(secondNumber));

        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    public void testDisplayWhiteBox_div() {

        int firstNumber = 10;
        int secondNumber = 2;
        int result = firstNumber / secondNumber;

        EditText FirsteditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(FirsteditText, String.valueOf(firstNumber));

        solo.clickOnButton("/");

        EditText SecondeditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(SecondeditText, String.valueOf(secondNumber));

        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    public void testDisplayWhiteBox_divZero() throws ArithmeticException {
        try {
            int firstNumber = 10;
            int secondNumber = 0;

            EditText FirsteditText = (EditText) solo.getView(R.id.editText1);
            solo.enterText(FirsteditText, String.valueOf(firstNumber));

            solo.clickOnButton("/");

            EditText SecondeditText = (EditText) solo.getView(R.id.editText1);
            solo.enterText(SecondeditText, String.valueOf(secondNumber));

            solo.clickOnButton("=");
            //fail("You just divided by zero, didn't you?");
        } catch (ArithmeticException e) {
            assertEquals("You just divided by zero, didn't you?", e.getMessage());
        }
    }

    @SmallTest
    public void testDisplayWhiteBox_mul() {

        int firstNumber = 10;
        int secondNumber = 20;
        int result = firstNumber * secondNumber;

        EditText FirsteditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(FirsteditText, String.valueOf(firstNumber));

        solo.clickOnButton("*");

        EditText SecondeditText = (EditText) solo.getView(R.id.editText1);
        solo.enterText(SecondeditText, String.valueOf(secondNumber));

        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    //pressing buttons
    public void testButtonsWhiteBox_sum() {

        int firstNumber = 10;
        int secondNumber = 20;
        int result = firstNumber + secondNumber;

        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("+");
        solo.clickOnButton("2");
        solo.clickOnButton("0");

        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    public void testButtonsWhiteBox_mul() {

        int firstNumber = 10;
        int secondNumber = 20;
        int result = firstNumber * secondNumber;

        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("*");
        solo.clickOnButton("2");
        solo.clickOnButton("0");

        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    public void testButtonsWhiteBox_minus() {

        int firstNumber = 20;
        int secondNumber = 10;
        int result = firstNumber - secondNumber;

        solo.clickOnButton("2");
        solo.clickOnButton("0");
        solo.clickOnButton("-");
        solo.clickOnButton("1");
        solo.clickOnButton("0");

        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    public void testButtonsWhiteBox_div() {

        int firstNumber = 10;
        int secondNumber = 2;
        int result = firstNumber / secondNumber;

        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("/");
        solo.clickOnButton("2");


        solo.clickOnButton("=");

        assertTrue(solo.searchText(String.valueOf(result)));
        EditText outputField = (EditText) solo.getView(R.id.editText1);

        assertEquals(String.valueOf(result), outputField.getText().toString());
    }

    @SmallTest
    public void testButtonsWhiteBox_divZero() throws ArithmeticException {
        try {

            solo.clickOnButton("1");
            solo.clickOnButton("0");
            solo.clickOnButton("/");
            solo.clickOnButton("0");

            solo.clickOnButton("=");
            //fail("You just divided by zero, didn't you?");
        } catch (ArithmeticException e) {
            assertEquals("You just divided by zero, didn't you?", e.getMessage());
        }
    }
}
