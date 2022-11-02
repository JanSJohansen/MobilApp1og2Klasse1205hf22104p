package dk.tec.sensorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView txtXY, txtXZ, txtYZ;
    LinearLayout layout;

    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtXY = findViewById(R.id.txtXY);
        txtXZ = findViewById(R.id.txtXZ);
        txtYZ = findViewById(R.id.txtYZ);

        layout = findViewById(R.id.layout);
        MyGraphics myGraphics = new MyGraphics(this);
        layout.addView(myGraphics);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(
                myGraphics,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                30000);
    }
}