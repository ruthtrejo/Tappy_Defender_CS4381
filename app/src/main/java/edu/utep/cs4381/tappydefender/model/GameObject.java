package edu.utep.cs4381.tappydefender.model;

import android.content.Context;

import java.util.Random;

public abstract class GameObject {

    /*
        All game objects need speed, the x & y coordinate and knowledge of the screen.
        There is also a need for a random object for generating. So it is here.
    * */
    protected int speed, x, y, screenWidth, screenHeight;
    protected static final Random random = new Random();

    public GameObject(Context context, int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getSpeed() {
        return this.speed;
    }

    // Update is left abstract. Most have their own implementations.
    public abstract void update(int speed);
}