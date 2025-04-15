package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText firstET;
    private EditText secondET;
    private TextView sumTV;
    private TextView minusTV;
    private TextView multiTV;
    private TextView deplyTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        firstET = findViewById(R.id.firstET);
        secondET = findViewById(R.id.secondET);
        sumTV = findViewById(R.id.sumTV);
        minusTV = findViewById(R.id.minusTV);
        multiTV = findViewById(R.id.multiTV);
        deplyTV = findViewById(R.id.deplyTV);
    }


    public void onClick(View view) {
        if (firstET.getText().length() == 0 || secondET.getText().length() == 0) {
            sumTV.setText("Введите числа!");
            minusTV.setText("Введите числа!");
            multiTV.setText("Введите числа!");
            deplyTV.setText("Введите числа!");
        } else {
            //sum
            int sum = Integer.parseInt(firstET.getText().toString()) + Integer.parseInt(secondET.getText().toString());
            sumTV.setText("Сумма: " + sum);

            //minus
            int minus = Integer.parseInt(firstET.getText().toString()) - Integer.parseInt(secondET.getText().toString());
            minusTV.setText("Разница: " + minus);

            //multiply
            int multi = Integer.parseInt(firstET.getText().toString()) * Integer.parseInt(secondET.getText().toString());
            multiTV.setText("Умножение: " + multi);

            //deply
            if (Integer.parseInt(firstET.getText().toString()) == 0 | Integer.parseInt(secondET.getText().toString()) == 0) {
                deplyTV.setText("Делить на 0 нельзя.");
            } else {
                int deply = Integer.parseInt(firstET.getText().toString()) / Integer.parseInt(secondET.getText().toString());
                deplyTV.setText("Деление: " + deply);
            }
        }
    }
}