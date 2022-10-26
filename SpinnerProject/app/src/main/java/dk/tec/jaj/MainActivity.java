package dk.tec.jaj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity
{
    String[] navne = {"Emil", "Bilal", "Azam", "Nicholas", "Oliver", "Afrina", "Malthe", "Anders", "Robin", "Jan"};
    Spinner spnElever;
    Button btnOK;
    TextView txtChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnElever = findViewById(R.id.spnElever);
        ArrayAdapter<String> elevAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        navne);
        spnElever.setAdapter(elevAdapter);

        spnElever.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String navn = navne[position];
                Toast.makeText(MainActivity.this, navn, Toast.LENGTH_LONG).show();
                Log.d("MyTag", navn);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnOK = findViewById(R.id.btnOK);
        txtChosen = findViewById(R.id.txtChosen);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = spnElever.getSelectedItem().toString();
                txtChosen.setText(name);
            }
        });
    }
}