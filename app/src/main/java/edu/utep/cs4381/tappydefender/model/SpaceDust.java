package edu.utep.cs4381.tappydefender.model;

import android.content.Context;

import java.util.Random;

public class SpaceDust extends GameObject{

    // Radius is for the size of our starts. Some are smaller and slower and others are faster and bigger
    private int maxX, maxY, radius;

    public SpaceDust(Context context,int screenX, int screenY) {
        super(context, screenX, screenY);
        maxX = screenX;
        maxY = screenY;
        /*
            SpaceDust needs lots of random generating.
        */
        setRandomDistance();
        setRandomSpeed();
        setRandomHeight();
        radius = speed - 7;
    }

    private void setRandomDistance() {
        x = random.nextInt(maxX);
    }

    private void setRandomSpeed(){
        speed = random.nextInt(3) + 10;
    }

    private void setRandomHeight() {
        y = random.nextInt(maxY);
    }

    public void update(int playerSpeed) {
        x -= speed;
        // The resetting functionality for resetting our stars.
        if (x < 0) {
            setRandomSpeed();
            x = maxX;
            setRandomHeight();
        }
    }

    public int getRadius() { return radius; }
}