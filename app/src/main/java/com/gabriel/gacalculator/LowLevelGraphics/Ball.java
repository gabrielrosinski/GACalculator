package com.gabriel.gacalculator.LowLevelGraphics;

import android.graphics.Color;
import android.graphics.Paint;

public class Ball {

    Paint paint = new Paint();

    int localX = 900;
    int localY = 900;
    int movmentSpeedX = -10;
    int movmentSpeedY = 10;
    int radius = 80;
    float movmentAngle = 30.0f;

    public Ball(){

        paint.setAntiAlias(true);
//        paint.setColor(Color.parseColor("#da4747"));
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
    }
}
