package edu.utep.cs4381.tappydefender.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import edu.utep.cs4381.tappydefender.R;

/* Authors: Ruth Trejo & Jose Eduardo Soto */
public class PlayerShip extends Ship {

    // GRAVITY is the falling rate for our player
    private static final int GRAVITY = -12;
    // Limits of range for our speed.
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 20;

    // Flag for accelerating and rising functionality in game
    private boolean boosting;

    // Range of our screen
    private int maxY;
    private int minY;

    // Shield record. Lose all of these and you lose
    private int shieldStrength;

    public void setBoosting(boolean flag) {
        boosting = flag;
    }

    public PlayerShip(Context context, int screenWidth, int screenHeight, Bitmap bitmap) {
        super(context, screenWidth, screenHeight, bitmap);
        // Player starts here always.
        this.x = 50;
        this.y = 50;
        speed = 1;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.bitmap = bitmap;
        maxY = screenHeight - this.bitmap.getHeight();
        minY = 0;
        this.hitbox = new Rect(x, y, this.bitmap.getWidth(), this.bitmap.getHeight());
        this.shieldStrength = 3;
    }

    public void update(int s) {
        // increment speed while boosting
        if (boosting) {
            speed += 2;
        } else {
            speed -= 5;
        }
        // assert speed limits
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        // algo for the falling
        y -= speed + GRAVITY;
        if (y < minY) {
            y = minY;
        }
        if (y > maxY) {
            y = maxY;
        }
        hitbox.set(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    /* Reduce shield strength if enemy ship collides with player ship*/
    public int reduceShieldStrength() {
        shieldStrength--;
        return shieldStrength;
    }

    /* Increase shield strength if power up collides with PlayerShip*/
    public void increaseShieldStrength(){ shieldStrength++; }
}