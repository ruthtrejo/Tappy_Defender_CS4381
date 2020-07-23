package edu.utep.cs4381.tappydefender.model;

import android.content.Context;
import android.media.SoundPool;

import edu.utep.cs4381.tappydefender.R;

public class SoundEffect {
    public enum Sound {
        START(R.raw.start),
        BUMP(R.raw.bump),
        DESTROYED(R.raw.destroyed),
        WIN(R.raw.win);

        public final int resourceID;
        private int soundID;

        Sound(int resourceID) {
            this.resourceID = resourceID;
        }

    }

    private final SoundPool soundPool;

    public SoundEffect(Context context) {
        soundPool = new SoundPool.Builder().setMaxStreams(Sound.values().length).build();
        for (Sound sound: Sound.values()) {
            sound.soundID = soundPool.load(context, sound.resourceID, 1);
        }
    }

    public void play(Sound sound) {
        soundPool.play(sound.soundID, 1, 1, 0, 0, 1);
    }
}