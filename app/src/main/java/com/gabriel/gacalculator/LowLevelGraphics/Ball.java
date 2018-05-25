package com.gabriel.gacalculator.LowLevelGraphics;

import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;


public class Ball {

    Paint paint = new Paint();

    int localX = 0;
    int localY = 0;
    int movmentSpeedX = 10;
    int movmentSpeedY = 10;
    int radius = 80;
    float movmentAngle = 30.0f;


    public Ball(float locationX, float locatoinY){

        Random rnd = new Random();

        paint.setAntiAlias(true);
        paint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        paint.setStyle(Paint.Style.FILL);

        localX = (int) locationX;
        localY = (int) locatoinY;


        movmentSpeedX = movmentSpeedX * ((rnd.nextInt() % 2 == 0) ? 1 : -1);
        movmentSpeedY = movmentSpeedY * ((rnd.nextInt() % 2 == 0) ? 1 : -1);

        movmentAngle = getRandomValue(0, 360);

    }


    private int getRandomValue(int minValue, int maxValue){

        int min = minValue;
        int max = maxValue;

        Random r = new Random();
        int randomValue = r.nextInt(max - min + 1) + min;

        return randomValue;
    }

}
