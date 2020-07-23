package edu.utep.cs4381.tappydefender;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

/* Authors: Ruth Trejo & Jose Eduardo Soto */
public class GameActivity extends AppCompatActivity {

    /* TDView knows all objects */
    private TDView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);


        /* Linking TDView to GameActivity*/
        gameView = new TDView(this, size.x, size.y);
        setContentView(gameView);
    }

    /* Animation is paused in sync with activity.*/
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }//end onPause

    /* Animation resumes in sync with activity. */
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}