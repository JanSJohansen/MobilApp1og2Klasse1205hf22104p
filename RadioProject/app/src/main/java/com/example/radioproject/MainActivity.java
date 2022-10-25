package com.example.radioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button btnShowRadio;
    TextView txtShowRadio;
    RadioGroup rdgProgLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowRadio = findViewById(R.id.btnShowRadio);
        txtShowRadio = findViewById(R.id.txtShowRadio);
        rdgProgLanguage = findViewById(R.id.rdgProgLanguage);
        btnShowRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                RadioButton chosen =
                        findViewById(rdgProgLanguage.getCheckedRadioButtonId());
                txtShowRadio.setText(chosen.getText());

                switch(rdgProgLanguage.getCheckedRadioButtonId())
                {
                    case R.id.rdbJava:
                        //
                        break;

                }
            }
        });
    }
}