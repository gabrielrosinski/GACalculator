package com.gabriel.gacalculator.LowLevelGraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View{


    Ball ball = new Ball();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        //collision detection
        if(ball.localX + ball.radius > this.getWidth()) {
            ball.localX = this.getWidth() - ball.radius;
            ball.movmentSpeedX = -ball.movmentSpeedX;
        }
        if(ball.localY + ball.radius  > this.getHeight()) {
            ball.localY = this.getHeight() - ball.radius;
            ball.movmentSpeedY = -ball.movmentSpeedY;
        }
        if(ball.localX - ball.radius < 0) {
            ball.localX = 0 + ball.radius;
            ball.movmentSpeedX = -ball.movmentSpeedX;
        }
        if(ball.localY - ball.radius < 0) {
            ball.localY = 0 + ball.radius;
            ball.movmentSpeedY = -ball.movmentSpeedY;
        }

        ball.localX = ball.localX + ball.movmentSpeedX;
        ball.localY = ball.localY + ball.movmentSpeedY;


        canvas.drawCircle(ball.localX, ball.localY, ball.radius, ball.paint);
        invalidate();
    }
}
