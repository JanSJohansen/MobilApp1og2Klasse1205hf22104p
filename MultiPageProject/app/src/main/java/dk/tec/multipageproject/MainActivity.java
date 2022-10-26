package dk.tec.multipageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity
{
    Button btnGoToSecond;
    TextView txtFromSecond;
    EditText txtToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFromSecond = findViewById(R.id.txtFromSecond);
        txtToSecond = findViewById(R.id.txtToSecond);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);
        btnGoToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("FromMain", txtToSecond.getText().toString());
                startActivity(intent);
            }
        });
    }
}