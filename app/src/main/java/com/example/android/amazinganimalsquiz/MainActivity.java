package com.example.android.amazinganimalsquiz;


import android.content.Intent;
import android.media.MediaPlayer;

import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


import static android.view.KeyEvent.KEYCODE_ENTER;


public class MainActivity extends AppCompatActivity {


    private ImageView ngLogo;
    private EditText nameEnter;
    private String userName;
    private VideoView mVideoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();
        setUpMediaPlayer();
        startAnimationLogo(ngLogo);
        startAnimationTextEdit(nameEnter);
        nextActivityStart();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("User name", userName);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        userName = savedInstanceState.getString("User name");
    }

    private void setUpViews() {
        ngLogo = (ImageView) findViewById(R.id.ngLogo);
        nameEnter = (EditText) findViewById(R.id.nameEnter);
        mVideoView = (VideoView) findViewById(R.id.logoView);


    }

// Video on backgound
    private void setUpMediaPlayer() {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2);
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);

            }
        });
    }

    private void nextActivityStart() {
        nameEnter.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                boolean consumed = false;
                if (keyCode == KEYCODE_ENTER) {

                    Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                    intent.putExtra("userName", nameEnter.getText().toString());
                    Toast.makeText(MainActivity.this,
                            "Welcome to world of animal"+" "+ nameEnter.getText() +""+"!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    //Делаем то, что нам нужно...
                    consumed = true; //это если не хотим, чтобы нажатая кнопка обрабатывалась дальше видом, иначе нужно оставить false

                }

                return consumed;
            }
        });
    }

    //**************************SOME ANIMATIONS***********************

    //View animation library - https://github.com/daimajia/AndroidViewAnimations
    //Method for logo (National Geographic Kids)
    public static void startAnimationLogo(View view) {
        //without params
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(view);
        //with params
        //        YoYo.with(Techniques.FadeInUp)
        //
        //                .repeat(1)
        //                .playOn(view);
        //
    }


    private void startAnimationTextEdit(View view) {
        YoYo.with(Techniques.Shake).duration(3000).playOn(view);

    //animations for


    }
    //**********************************************************************************************



}
