package edu.utep.cs4381.tappydefender.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;

import androidx.constraintlayout.solver.widgets.Helper;


public class PowerUp extends GameObject{

    private final Handler HANDLER = new Handler();
    private int maxX, minX; // move horizontally from right to left
    private int maxY, minY;

    protected Bitmap bitmap;
    protected Rect hitbox;

    public PowerUp(Context ctx, int screenX, int screenY, Bitmap bitmap){
        super(ctx, screenX, screenY);
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        this.bitmap = bitmap;
        hitbox = new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());

        displayNewPowerUp();
    }

    public void update(int powerUpSpeed) {
        x -= powerUpSpeed;
        x -= speed;
        // What happens when the power up reaches the end of the screen
        if (x < minX - bitmap.getWidth()) {
            displayNewPowerUp();
        }
        hitbox.set(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
    }

    public void displayNewPowerUp() {
        speed = random.nextInt(10)+10;
        x = maxX;
        y = random.nextInt(maxY) - bitmap.getHeight();
    }

    public Rect getHitbox(){ return hitbox; }
    public Bitmap getBitmap(){ return bitmap; }
}
