package dk.tec.multipageproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

    final static String TEXT_FROM_MAIN = "FromMain";
    final static String TEXT_FROM_SECOND = "FromSecond";

    ActivityResultLauncher<Intent> secondLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFromSecond = findViewById(R.id.txtFromSecond);
        txtToSecond = findViewById(R.id.txtToSecond);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);

        secondLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result)
                    {
                        if(result.getResultCode() == Activity.RESULT_OK)
                        {
                            Intent data = result.getData();
                            txtFromSecond.setText(data.getStringExtra(TEXT_FROM_SECOND));
                        }}}
        );
        btnGoToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(TEXT_FROM_MAIN, txtToSecond.getText().toString());
                //startActivity(intent);
                secondLauncher.launch(intent);
            }
        });



    }
}