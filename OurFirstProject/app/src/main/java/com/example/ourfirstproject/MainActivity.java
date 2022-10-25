package com.example.ourfirstproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener
{
    int count = 0;
    public TextView txtMessage;
    Button btnHandlerMain;
    Button btnAnonymHandler;
    Button btnExtHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_main);

        txtMessage = findViewById(R.id.txtMessage);

        btnHandlerMain = findViewById(R.id.btnHandlerMain);
        btnHandlerMain.setOnClickListener(this);

        btnAnonymHandler = findViewById(R.id.btnAnonymHandler);
        btnAnonymHandler.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtMessage.setText("Der blev trykk OK");
                count++;
            }
        });
        btnExtHandler = findViewById(R.id.btnExtHandler);
        btnExtHandler.setOnClickListener(new MyHandler(this));

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btnAnonymHandler:
                //
                break;
            case R.id.btnHandlerMain:
                //
                break;
            case R.id.btnExtHandler:
                //
                break;
        }

        Button btn = (Button)v;
        btn.setText("Nu er der trykket");
    }
}