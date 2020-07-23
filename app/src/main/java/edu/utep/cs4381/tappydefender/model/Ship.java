package edu.utep.cs4381.tappydefender.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import edu.utep.cs4381.tappydefender.R;

public abstract class Ship extends GameObject{

    /*
        All Ships need their bitmaps and hitboxes. These are the more fat objects in our
        game. All of the inheriting classes need this bitmap and hitboxes to be generated for them.
     */
    protected Bitmap bitmap;
    protected Rect hitbox;

    public Ship(Context context, int screenWidth, int screenHeight, Bitmap bitmap) {
        super(context, screenWidth, screenHeight);
        this.bitmap = bitmap;
        this.hitbox = new Rect(this.x, this.y, this.bitmap.getWidth(), this.bitmap.getHeight());
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public Rect getHitbox() {
        return this.hitbox;
    }
}