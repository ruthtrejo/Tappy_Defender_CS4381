package edu.utep.cs4381.tappydefender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/* Authors: Ruth Trejo & Jose Eduardo Soto */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.startGameBtn);
        playButton.setOnClickListener(view -> {
            /*Framework method that launches new activity (argument is an intent)
            once the button is pressed, GameActivity is launched! */
            startActivity(new Intent(this, GameActivity.class));
            finish(); //destroys MainActivity
        });

    }
}