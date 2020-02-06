package com.martinscastanho.marco.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Integer[] resources = {R.raw.doyouspeakenglish, R.raw.goodevening, R.raw.hello, R.raw.howareyou, R.raw.ilivein, R.raw.mynameis, R.raw.please, R.raw.welcome};
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playPhrase(View view){
        Integer buttonId = Integer.parseInt((String) view.getTag());
        mediaPlayer = MediaPlayer.create(this, resources[buttonId]);
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mediaPlayer.start();
    }
}
