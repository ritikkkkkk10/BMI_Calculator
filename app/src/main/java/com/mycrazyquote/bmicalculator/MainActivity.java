package com.mycrazyquote.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{

     RadioButton maleButton;
     RadioButton femaleButton;
     EditText ageEditText;
     EditText feetEditText;
     EditText inchesEditText;
     EditText weightEditText;
     Button calculateButton;

     TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();


    }



    private void findViews()
    {
        name= findViewById(R.id.text_view_result);
        maleButton = findViewById(R.id.radio_male_button);
        femaleButton = findViewById(R.id.radio_female_button);

        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);


        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener()
    {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                calculateBmi();
            }
        });
    }

    private void calculateBmi()
    {
        String ageText=ageEditText.getText().toString();
        String feetText=feetEditText.getText().toString();
        String inchesText=inchesEditText.getText().toString();
        String weightText=weightEditText.getText().toString();

        int age=Integer.parseInt(ageText);
        int feet=Integer.parseInt(feetText);
        int inches=Integer.parseInt(inchesText);
        int weight=Integer.parseInt(weightText);

        int totalInches=(feet*12)+inches;
        double heightInMeters=totalInches*0.0254;

        double bmi=weight/(heightInMeters*heightInMeters);
        DecimalFormat in=new DecimalFormat("0.00");

        String fullString;
        String bmiTextResult=in.format(bmi);
        if(bmi<18.5)
            fullString=bmiTextResult+"-You are underweight";
        else if(bmi>25)
            fullString=bmiTextResult+"-You are overweight";
        else
            fullString=bmiTextResult+"-You are healthy";
        name.setText(fullString);



    }
}