package dk.tec.customizedlistproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView lstBiler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstBiler = findViewById(R.id.lstBiler);

        ArrayList<Bil> biler = new ArrayList<Bil>();
        biler.add(new Bil(1000, "BMW Isetta GTI",
                "0-100 på 5 min", R.drawable.bmw_isetta1));
        biler.add(new Bil(1001, "BMW Isetta 3 wheels",
                "Min nye kabinescooter", R.drawable.bmw_isetta2));
        biler.add(new Bil(1002, "BMW Isetta HDMI",
                "Bæredygtig og grøn", R.drawable.bmw_isetta3));
        biler.add(new Bil(1003, "BMW Isetta 4 wheels",
                "Stor familiebil", R.drawable.bmw_isetta4));
        biler.add(new Bil(1004, "BMW Isetta Cabriolet",
                "Uden tag overhovedet", R.drawable.bmw_isetta5));
        biler.add(new Bil(1005, "BMW Isetta Van",
                "God til flyttemænd", R.drawable.bmw_isetta6));
        biler.add(new Bil(1006, "BMW Isetta Bus",
                "60 personers omnibus", R.drawable.bmw_isetta7));
        biler.add(new Bil(1007, "BMW Isetta Sport",
                "Gi den gas og baghjul", R.drawable.bmw_isetta8));

        BilAdapter bilAdapter = new BilAdapter(biler, this);
        lstBiler.setAdapter(bilAdapter);

    }
}