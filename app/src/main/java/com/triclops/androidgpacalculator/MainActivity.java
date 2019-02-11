package com.triclops.androidgpacalculator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends FragmentActivity {

	private TextView gpaLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gpaLabel = (TextView) findViewById(R.id.gpaLabel);


	}



		public void onCalcPress (View view){
		final EditText text = (EditText) findViewById(R.id.editText);
		final EditText text1 = (EditText) findViewById(R.id.editText1);
		final EditText text2 = (EditText) findViewById(R.id.editText3);
		final EditText text3 = (EditText) findViewById(R.id.editText4);
		final EditText text4 = (EditText) findViewById(R.id.editText5);
		String[] mArray = getResources().getStringArray(R.array.gradeArray);
		String sol = text.getText().toString();
		String sol1 = text1.getText().toString();
		String sol2 = text2.getText().toString();
		String sol3 = text3.getText().toString();
		String sol4 = text4.getText().toString();
		int index = -1;
		int index1 = -1;
		int index2 = -1;
		int index3 = -1;
		int index4 = -1;
		for (int i = 0; i < mArray.length; i++) {
			if (mArray[i].equals(sol)) {
				index = i;
			}
			if (mArray[i].equals(sol1)) {
				index1 = i;
			}
			if (mArray[i].equals(sol2)) {
				index2 = i;
			}
			if (mArray[i].equals(sol3)) {
				index3 = i;
			}
			if (mArray[i].equals(sol4)) {
				index4 = i;
			}
		}


		Button p1_button = (Button) findViewById(R.id.calculateButton);
		if (p1_button.getText() == "Clearform") {
			finish();
			startActivity(getIntent());
		} else p1_button.setText("Clearform");


		final int class1 = index;
		final int class2 = index1;
		final int class3 = index2;
		final int class4 = index3;
		final int class5 = index4;
		if (class1 != -1 && class2 != -1 && class3 != -1 && class4 != -1 && class5 != -1) {
			float GPA = GPACalc.getGPA(class1, class2, class3, class4, class5);
			float percentage = (GPA / 4) * 100;
			gpaLabel.setText(getResources().getText(R.string.gpaLabel) + " " + Float.toString(GPA) + "Percentage = " + Float.toString(percentage));
			if (percentage <= 60.5) {
				LinearLayout bgElement = (LinearLayout) findViewById(R.id.container);
				bgElement.setBackgroundColor(Color.RED);
			}
			if (percentage > 60.5 && percentage <= 79.5) {
				LinearLayout bgElement = (LinearLayout) findViewById(R.id.container);
				bgElement.setBackgroundColor(Color.YELLOW);
			}
			if (percentage > 79.5) {
				LinearLayout bgElement = (LinearLayout) findViewById(R.id.container);
				bgElement.setBackgroundColor(Color.GREEN);
			}

		} else {
			Toast.makeText(MainActivity.this, "Enter correct grades", Toast.LENGTH_SHORT).show();
			if (class1 == -1) {
				text.setTextColor(Color.RED);
			}
			if (class2 == -1) {
				text1.setTextColor(Color.RED);
			}
			if (class3 == -1) {
				text2.setTextColor(Color.RED);
			}
			if (class4 == -1) {
				text3.setTextColor(Color.RED);
			}
			if (class5 == -1) {
				text4.setTextColor(Color.RED);
			}

		}
	}
	
	}
