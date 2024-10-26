package com.example.midtermabhyaung;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText radiusInput;
    private TextView resultText;
    private static final double PI = 3.14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiusInput = findViewById(R.id.radiusInput);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateArea();
            }
        });
    }


    private void resetFields() {
        radiusInput.setText(""); // Clear the input field
        resultText.setText("Area: 0"); // Reset output to default value
    }

    @SuppressLint("SetTextI18n")
    private void calculateArea() {
        String radiusStr = radiusInput.getText().toString();
        if (radiusStr.isEmpty()) {
            Toast.makeText(this, "Please enter a radius", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double radius = Double.parseDouble(radiusStr);
            double area = PI * radius * radius;
            resultText.setText("Area: " + area);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }
}
