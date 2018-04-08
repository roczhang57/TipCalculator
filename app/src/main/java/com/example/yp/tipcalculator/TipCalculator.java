package com.example.yp.tipcalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.content.ComponentName;
import android.widget.Toast;


import static com.example.yp.tipcalculator.R.id.editText1;

public class TipCalculator extends Activity {


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setTheme(android.R.style.Theme);
        setContentView(R.layout.activity_tip_calculator);


        // Set up click listeners for all the buttons
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);

        // declare textview
        final TextView textViewA = (TextView) findViewById(R.id.textViewA);
        final TextView textViewB = (TextView) findViewById(R.id.textViewB);
        final TextView textViewC = (TextView) findViewById(R.id.textViewC);
        final TextView textViewD = (TextView) findViewById(R.id.textViewD);

        // declare edittext
        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);

        // set default value for tip
        editText3.setText("15");


        // set click button function
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // declare input1, input2
                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();

                // set variable for total amount, number of people
                double total = 0;
                int numOfPpl = 0;

                // input1 with value
                if (!input1.equals("")) {
                    total = Double.parseDouble(input1);
                }

                //input2 with value
                if (!input2.equals("")) {
                    numOfPpl = Integer.parseInt(input2);
                }
                //calculate amount per person
                double amountPerPpl = total / numOfPpl;
                String outputB = String.format("%.2f", amountPerPpl);
                // output of amount per person
                textViewB.setText(outputB);
                // output for total
                String outputA = String.format("%.2f", total);
                textViewA.setText(outputA);

                // declare input for tip percentage
                String tipInput = editText3.getText().toString();
                double tipPercentage = Double.parseDouble(tipInput);
                double tip;
                // calculate tip
                tip = total * (tipPercentage * .01);
                String outputC = String.format("%.2f", tip);
                textViewC.setText(outputC);

                // calculate tip per person
                double tipPerPerson = tip / numOfPpl;
                String outputD = String.format("%.2f", tipPerPerson);
                textViewD.setText(outputD);
            }

        });
        // web button function
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w1 = new Intent(TipCalculator.this, Web.class);
                startActivity(w1);
            }
        });

        // dial button function
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:7818912000");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        // map button function
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=175 forest street MA 02451");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else
                    Toast.makeText(TipCalculator.this,
                            "GoogleMaps not available", Toast.LENGTH_LONG).show();

            }
        });

    }
}