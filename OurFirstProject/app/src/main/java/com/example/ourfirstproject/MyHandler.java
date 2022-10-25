package com.example.ourfirstproject;

import android.view.View;
import android.widget.TextView;

public class MyHandler implements View.OnClickListener
{
    TextView txtToWrite;
    MainActivity act;

    public MyHandler(TextView txtToWrite)
    {
        this.txtToWrite = txtToWrite;
    }

    public MyHandler(MainActivity activity)
    {
        act = activity;
    }

    @Override
    public void onClick(View v)
    {
        //txtToWrite.setText("Hej");
        act.txtMessage.setText("Hej fra External class");

    }
}
