package com.gabriel.gacalculator.LowLevelGraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View{


    ArrayList<Ball> ballArray = new ArrayList<Ball>();

    static final int maxNumOfBalls = 10;


    int rectLeftPoint = 0;
    int rectRightPoint = 0;
    int rectTopPoint = 0;
    int rectBottomPoint = 0;


    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

//        ballArray.add(new Ball(this.getWidth(), this.getHeight()));
//        ballArray.add(new Ball(this.getWidth(), this.getHeight()));

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float touchedX = event.getX();
            float touchedY = event.getY();
//            isTouched = true;

            if (ballArray.size() < maxNumOfBalls ) {
                ballArray.add(new Ball(touchedX, touchedY));
            }else{
                ballArray.remove(0);
                ballArray.add(new Ball(touchedX, touchedY));
            }

            postInvalidateOnAnimation();
            return true;
        }
//        else {
//            isTouched = false;
//        }

        // will trigger a new call to onDraw()
        postInvalidateOnAnimation();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);




        for (Ball ball : this.ballArray)
        {
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


            checkCollisionWithRect(ball);

            ball.localX = ball.localX + ball.movmentSpeedX;
            ball.localY = ball.localY + ball.movmentSpeedY;

            canvas.drawCircle(ball.localX, ball.localY, ball.radius, ball.paint);

        }


        drawRect(canvas);

        invalidate();

    }


    private void checkCollisionWithRect(Ball ball){


        int ballXLocPluse = ball.localX + ball.radius;
        int ballXLocMinus = ball.localX - ball.radius;
        int ballYLocPluse = ball.localY + ball.radius;
        int ballYLocMinus = ball.localY - ball.radius;


//        if(ball.localX + ball.radius > rectLeftPoint) {
//            ball.localX = rectLeftPoint - ball.radius;
//            ball.movmentSpeedX = -ball.movmentSpeedX;
//        }
//        if(ball.localY + ball.radius  > rectBottomPoint) {
//            ball.localY = rectBottomPoint - ball.radius;
//            ball.movmentSpeedY = -ball.movmentSpeedY;
//        }
//        if(ball.localX - ball.radius < rectRightPoint) {
//            ball.localX = rectRightPoint + ball.radius;
//            ball.movmentSpeedX = -ball.movmentSpeedX;
//        }
//        if(ball.localY - ball.radius < rectTopPoint) {
//            ball.localY = rectTopPoint + ball.radius;
//            ball.movmentSpeedY = -ball.movmentSpeedY;
//        }


        if (ballXLocPluse > rectRightPoint && ballXLocMinus < rectRightPoint  && ballYLocPluse > rectTopPoint && ballYLocPluse < rectBottomPoint) {
            ball.localX = rectRightPoint + ball.radius;
            ball.movmentSpeedX = -ball.movmentSpeedX;
        }

        if (ballXLocPluse > rectLeftPoint && ballXLocMinus < rectLeftPoint && ballYLocPluse > rectTopPoint && ballYLocPluse < rectBottomPoint) {
            ball.localX = rectLeftPoint - ball.radius;
            ball.movmentSpeedX = -ball.movmentSpeedX;
        }

        if (ballYLocPluse > rectTopPoint && ballYLocMinus < rectTopPoint && ballXLocPluse < rectRightPoint && ballXLocPluse > rectLeftPoint){
            ball.localY = rectTopPoint - ball.radius;
            ball.movmentSpeedY = -ball.movmentSpeedY;
        }

        if (ballYLocPluse > rectBottomPoint && ballYLocMinus < rectBottomPoint && ballXLocPluse < rectRightPoint && ballXLocPluse > rectLeftPoint){
            ball.localY = rectBottomPoint - ball.radius;
            ball.movmentSpeedY = -ball.movmentSpeedY;
        }

    }

    private void drawRect(Canvas canvas) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        rectLeftPoint = getWidth() / 2 - 200;
        rectRightPoint = rectLeftPoint + 300;
        rectTopPoint = getHeight() / 2 - 200;
        rectBottomPoint = rectTopPoint + 500;

        canvas.drawRect(rectLeftPoint,rectTopPoint, rectRightPoint, rectBottomPoint, paint);

    }
}
