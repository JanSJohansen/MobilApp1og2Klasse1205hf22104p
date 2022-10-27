package dk.tec.multipageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Method;

public class SecondActivity extends AppCompatActivity
{
    Button btnGoBack;
    TextView txtFromMain;
    EditText txtToMain;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtFromMain = findViewById(R.id.txtFromMain);
        txtToMain = findViewById(R.id.txtToMain);
        btnGoBack = findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent.putExtra(MainActivity.TEXT_FROM_SECOND, txtToMain.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        intent = getIntent();  // Den intent som Second er startet med
        String strFromMain = intent.getStringExtra(MainActivity.TEXT_FROM_MAIN);
        txtFromMain.setText(strFromMain);
    }
}









