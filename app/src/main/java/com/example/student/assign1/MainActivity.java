package com.example.student.assign1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private TextView textViewBMICalculator = null;
    private TextView textViewHeight = null;
    private TextView textviewWeight = null;
    private EditText editTextHeight = null;
    private EditText editTextWeight = null;
    private TextView textViewIndex = null;
    private TextView textViewResult = null;
    private Button calculateBtn = null;
    private TextView textViewCatagory = null;
    private TextView textViewCatagoryResult = null;
    private ImageView imageViewCatagory = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewBMICalculator = (TextView) findViewById(R.id.textViewBMICalculator);
        textViewHeight = (TextView) findViewById(R.id.textViewHeight);
        textviewWeight = (TextView) findViewById(R.id.textViewWeight);
        editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        textViewIndex = (TextView) findViewById(R.id.textViewIndex);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewCatagoryResult = (TextView) findViewById(R.id.textViewCatagoryResult);
        imageViewCatagory = (ImageView) findViewById(R.id.imageViewCatagory);
    }

    public void clickedCalculator(View view) {

        String editHeightString = editTextHeight.getText().toString();
        float editHeightDoble = 0;

        if (!editHeightString.isEmpty()) {
            editHeightDoble = Float.parseFloat(editHeightString) / 100;
        }

        String editWeightString = editTextWeight.getText().toString();
        float editWeightDouble = 0;

        if (!editWeightString.isEmpty()) {
            editWeightDouble = Float.parseFloat(editWeightString);
        }

        //calculate BMI Index
        float calculateBMIIndex = editWeightDouble / (editHeightDoble * editHeightDoble);

        String strFinalMessage = "" + calculateBMIIndex;

        textViewResult.setText(strFinalMessage);

        calculateCatagory(calculateBMIIndex);


    }

    private void calculateCatagory(float bmiIndex) {
        String displayCatagoryStr = "";

        if (Float.compare(bmiIndex, 15) <= 0) {
            displayCatagoryStr = "very severely underweight";
            imageViewCatagory.setImageResource(R.drawable.life);

        } else if (Float.compare(bmiIndex, 15) > 0 && Float.compare(bmiIndex, 16) <= 0) {
            displayCatagoryStr = "Severely Underweight";
            imageViewCatagory.setImageResource(R.drawable.ball);

        } else if (Float.compare(bmiIndex, 16) > 0 && Float.compare(bmiIndex, 18.5f) <= 0) {
            displayCatagoryStr = "Underweight";
            imageViewCatagory.setImageResource(R.drawable.again);

        } else if (Float.compare(bmiIndex, 18.5f) > 0 && Float.compare(bmiIndex, 25) <= 0) {
            displayCatagoryStr = "Normal";
            imageViewCatagory.setImageResource(R.drawable.again);

        } else if (Float.compare(bmiIndex, 25) > 0 && Float.compare(bmiIndex, 30) <= 0) {
            displayCatagoryStr = "Overweight";
            imageViewCatagory.setImageResource(R.drawable.life);

        } else if (Float.compare(bmiIndex, 30) > 0 && Float.compare(bmiIndex, 35f) <= 0) {
            displayCatagoryStr = "Moderately obese";
            imageViewCatagory.setImageResource(R.drawable.ball);

        } else if (Float.compare(bmiIndex, 35) > 0 && Float.compare(bmiIndex, 40) <= 0) {
            displayCatagoryStr = "Severely obese";
            imageViewCatagory.setImageResource(R.drawable.life);

        } else if (Float.compare(bmiIndex, 40) > 0 && Float.compare(bmiIndex, 50) <= 0) {
            displayCatagoryStr = "Very severely obese";
            imageViewCatagory.setImageResource(R.drawable.life);

        } else {
            displayCatagoryStr = "None";
            imageViewCatagory.setImageResource(0);

        }


        textViewCatagoryResult.setText(displayCatagoryStr);


    }

}




