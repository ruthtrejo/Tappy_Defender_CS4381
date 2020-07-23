package edu.utep.cs4381.tappydefender.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

import edu.utep.cs4381.tappydefender.R;

public class EnemyShip extends Ship{
    
    private int maxX, minX; // move horizontally from right to left
    private int maxY, minY;

    public EnemyShip(Context ctx, int screenX, int screenY, Bitmap bitmap){
        super(ctx, screenX, screenY, bitmap);
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        this.bitmap = bitmap;
        hitbox = new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
        resetShip();
    }

    public void update(int playerSpeed) {
        x -= playerSpeed;
        x -= speed;
        // What happens when our ship reaches the end of the screen.
        if (x < minX - bitmap.getWidth()) {
            resetShip();
        }
        hitbox.set(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
    }

    public void resetShip() {
        speed = random.nextInt(10)+10;
        x = maxX;
        y = random.nextInt(maxY) - bitmap.getHeight();
    }

}