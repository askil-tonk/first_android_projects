package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int a = random.nextInt(100);
    int b = random.nextInt(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnsw = findViewById(R.id.buttonAnsw);
        Button buttonRefresh = findViewById(R.id.buttonRefresh);

        TextView textViewIncorrectAnswer = findViewById(R.id.textViewIncorrectAnswer);
        TextView textViewCorrectAnswer = findViewById(R.id.textViewCorrectAnswer);
        TextView textViewExample = findViewById(R.id.textViewExample);

        textViewExample.setText(a + " + " + b + " = ");

        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = random.nextInt(100);
                b = random.nextInt(100);
                textViewExample.setText(a + " + " + b + " = ");
            }
        });

        buttonAnsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextAnswer.getText().toString();
                int number = Integer.parseInt(text);
                if (number == (a + b)) {
                    textViewCorrectAnswer.setVisibility(View.VISIBLE);
                    textViewIncorrectAnswer.setVisibility(View.GONE);
                } else {
                    textViewCorrectAnswer.setVisibility(View.GONE);
                    textViewIncorrectAnswer.setVisibility(View.VISIBLE);

                }
            }
        });

    }
}