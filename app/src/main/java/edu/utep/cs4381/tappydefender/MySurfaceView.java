package edu.utep.cs4381.tappydefender;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* Authors: Ruth Trejo & Jose Eduardo Soto */
public class MySurfaceView extends SurfaceView {
    //private BGThread thread;
    private SurfaceHolder holder;

    public MySurfaceView(Context context) {
        super(context);
        holder = getHolder();
    }

    public void draw() {
        Canvas canvas = holder.lockCanvas();
        //... draw on canvas ...
        holder.unlockCanvasAndPost(canvas);
    }
}