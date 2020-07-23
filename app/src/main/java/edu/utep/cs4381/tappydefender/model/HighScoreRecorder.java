package edu.utep.cs4381.tappydefender.model;

import android.content.Context;
import android.content.SharedPreferences;

public class HighScoreRecorder {
    private static final String PREF_FILE = "highScore";
    private static final String PREF_KEY = "fastestTime";
    private static final long DEFAULT_VALUE = Long.MAX_VALUE;
    private static HighScoreRecorder instance;

    private final SharedPreferences sharedPref;

    private HighScoreRecorder(Context context) {
        sharedPref = context.getSharedPreferences(PREF_FILE,
                Context.MODE_PRIVATE);
    }

    public void store(long time) {

    }

    public long retrieve() {
        return DEFAULT_VALUE;
    }

    public HighScoreRecorder instance(Context context) {
        if (instance == null) {
            instance = new HighScoreRecorder(context);
        }
        return instance;
    }
}