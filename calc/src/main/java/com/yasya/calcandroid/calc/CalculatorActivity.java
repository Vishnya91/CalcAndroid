package com.yasya.calcandroid.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends Activity {
	int duration = Toast.LENGTH_SHORT;
	int value = 0;
	EditText textView;
	String operation = "";
	Calculator calc = new Calculator();
	int k;
	int j;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		textView = (EditText) findViewById(R.id.editText1);

		for (j = 0; j <= 9; j++) {

			final Button[] buttons = { (Button) findViewById(R.id.button10),
					(Button) findViewById(R.id.button1),
					(Button) findViewById(R.id.button2),
					(Button) findViewById(R.id.button3),
					(Button) findViewById(R.id.button4),
					(Button) findViewById(R.id.button5),
					(Button) findViewById(R.id.button6),
					(Button) findViewById(R.id.button7),
					(Button) findViewById(R.id.button8),
					(Button) findViewById(R.id.button9) };

			buttons[j].setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					int index = 0;
					for (int i = 0; i < buttons.length; i++) {
						if (buttons[i].getId() == v.getId()) {
							index = i;
							break;
						}
					}
					textView.setText(textView.getText().toString() + index);
				}
			});
		}

		for (k = 0; k < 4; k++) {
			final Button[] buttonsOp = { (Button) findViewById(R.id.button11),
					(Button) findViewById(R.id.button12),
					(Button) findViewById(R.id.button13),
					(Button) findViewById(R.id.button14) };
			// Toast.makeText(getBaseContext(), buttonsOp.length,
			// duration).show();
			buttonsOp[k].setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String tag = "";
					for (int i = 0; i < buttonsOp.length; i++) {

						if (buttonsOp[i].getId() == v.getId()) {
							tag = buttonsOp[i].getTag().toString();
							break;
						}
					}
					// Toast.makeText(getBaseContext(), tag, duration).show();

					value = Integer.valueOf(textView.getText().toString());

					textView.setText("");
					textView.setHint("Enter the second number");
					operation = tag;
				}
			});
		}

		final Button buttonEq = (Button) findViewById(R.id.button15);
		buttonEq.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String secValue = textView.getText().toString();
				if (secValue != null && !"".equals(secValue)) {
					try {
						Integer secondValue = Integer.parseInt(secValue);
						if ("+".equals(operation)) {
							textView.setText((calc.sum(value, secondValue))
									+ "");
						}
						if ("-".equals(operation)) {
							textView.setText((calc.minus(value, secondValue))
									+ "");
						}
						if ("*".equals(operation)) {
							textView.setText((calc.mult(value, secondValue))
									+ "");
						}
						if ("/".equals(operation)) {
							try {
								textView.setText((calc.devide(value,
										secondValue)) + "");
							} catch (ArithmeticException ex) {
								ex.getMessage();
								Toast.makeText(
										getBaseContext(),
										"You just divided by zero, didn't you?",
										Toast.LENGTH_LONG).show();
							}
						}
						value = 0;
					} catch (NumberFormatException ex) {
						Toast.makeText(getBaseContext(), "Enter a number",
								Toast.LENGTH_LONG).show();
					}
				}
			}
		});
	}
}
