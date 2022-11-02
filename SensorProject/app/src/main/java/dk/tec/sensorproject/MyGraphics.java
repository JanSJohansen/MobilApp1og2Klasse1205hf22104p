package dk.tec.sensorproject;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class MyGraphics extends View implements SensorEventListener
{
    MainActivity mainActivity;
    Drawable kugle;
    int kugleWidth, kugleHeight;
    int xPos = 100, yPos = 100;
    double xAcc = 0, yAcc = 0;

    int width, height;

    public MyGraphics(MainActivity mainActivity)
    {
        super(mainActivity);
        this.mainActivity = mainActivity;
        kugle = getResources().getDrawable(R.drawable.kugle, null);
        kugleHeight = kugle.getMinimumHeight()/2;
        kugleWidth = kugle.getMinimumWidth()/2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        kugle.setBounds(xPos, yPos, xPos + kugleWidth, yPos + kugleHeight);
        kugle.draw(canvas);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        int xPosNew, yPosNew;

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            mainActivity.txtXY.setText(String.format("%4.1f",event.values[0]));
            mainActivity.txtXZ.setText(String.format("%4.1f",event.values[1]));
            mainActivity.txtYZ.setText(String.format("%4.1f",event.values[2]));

            xAcc += -event.values[0];
            yAcc += event.values[1];
            xPosNew = (int) (xPos + xAcc/2);
            yPosNew = (int) (yPos + yAcc/2);


            if(xPosNew + 30 < 0 || xPosNew + kugleWidth -30  > width)  // udenfor til venstre
            {
                xAcc = xAcc * -0.6;
            }
            else
            {
                xPos = xPosNew;
            }
//////////////
            if(yPosNew + 30 < 0 || yPosNew + kugleHeight -30  > height)  // udenfor til venstre
            {
                yAcc = yAcc * -0.6;
            }
            else
            {
                yPos = yPosNew;
            }
            invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
