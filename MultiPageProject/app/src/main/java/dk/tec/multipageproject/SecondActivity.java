package dk.tec.multipageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    Button btnGoBack;
    TextView txtFromMain;
    EditText txtToMain;

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
                finish();
            }
        });

        Intent intent = getIntent();  // Den intent som Second er startet med
        String strFromMain = intent.getStringExtra("FromMain");
        txtFromMain.setText(strFromMain);
    }
}









