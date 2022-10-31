package dk.tec.mygraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

public class TheGraphics extends View implements View.OnTouchListener, Runnable
{
    int xPos = 200, yPos = 300;
    int xLast, yLast;
    int radius = 100;
    boolean isMoving = false;

    Drawable imgEinstein;
    int xEinstein = 0, yEinstein = 0;
    int widthEin, heightEin;
    int xSpeed = 5, ySpeed = 5;

    int screenWidth, screenHeight;


    public TheGraphics(Context context)
    {
        super(context);
        setBackgroundColor(Color.LTGRAY);
        setOnTouchListener(this);

        imgEinstein = getResources().getDrawable(R.drawable.einstein1, null);
        widthEin = (int)(imgEinstein.getMinimumWidth()/10);
        heightEin = (int)(imgEinstein.getMinimumHeight()/10);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


        imgEinstein.setBounds(xEinstein, yEinstein,
                xEinstein + widthEin,
                yEinstein + heightEin);
        imgEinstein.draw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(xPos, yPos, radius, paint);
        paint.setColor(Color.BLUE);
        paint.setTextSize(100);
        canvas.drawText("Hej fra mig", 200, 400, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int xNew = (int)event.getX();
        int yNew = (int)event.getY();

        if(event.getPointerCount() == 2)
        {
            int x1 = (int)event.getX(0);
            int x2 = (int)event.getX(1);
            radius = Math.abs(x2 - x1);
            invalidate();
        }
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(Math.sqrt((xNew - xPos) * (xNew - xPos)
                        + (yNew - yPos) * (yNew - yPos)) < radius)
                {
                    isMoving = true;
                    xLast = xNew;
                    yLast = yNew;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(isMoving) {
                    xPos += xNew - xLast;
                    yPos += yNew - yLast;
                    xLast = xNew;
                    yLast = yNew;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                isMoving = false;
                break;
        }
        return true;
    }

    @Override
    public void run()
    {
        while(true)
        {
            xEinstein += xSpeed;
            yEinstein += ySpeed;

            if((xEinstein + widthEin) > screenWidth
               || xEinstein < 0)
            {
                xSpeed = xSpeed * -1;
            }

            if((yEinstein + heightEin) > screenHeight
                    || yEinstein < 0)
            {
                ySpeed = ySpeed * -1;
            }

            postInvalidate();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
