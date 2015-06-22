package net.lzs.animation03_learningallkindsofanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LEE on 2015/6/22.
 */
public class MyRectangle extends View {

    public MyRectangle(Context context) {
        super(context);
        init();
    }

    public MyRectangle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyRectangle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint paint;


    private void init()
    {
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.drawRect(new Rect(null),paint);

        canvas.restore();

    }
}
