package net.lzs.paint01_basicuseofpaintingapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LEE on 2015/6/21.
 */
public class MyPoint extends View {
    public MyPoint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyPoint(Context context) {
        super(context);
        init();
    }

    private Paint paint;
    private int count = 0;
    private float x = 0.0f,y = 0.0f;
    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            invalidate();

            if(count++ % 2 == 0)
            {
                paint.setColor(Color.TRANSPARENT);
            }
            else
            {
                paint.setColor(Color.CYAN);

            }
        }
    };

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public void init()
    {
        paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setAlpha(200);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.drawCircle(x,y, 10, paint);
        System.out.println(x + "======" + y);
//        canvas.drawCircle(getX(),getY(), 10, paint);
//        System.out.println(getX() + "======" + getY());
        canvas.restore();

        handler.sendEmptyMessageDelayed(0, 1000);

    }
}
