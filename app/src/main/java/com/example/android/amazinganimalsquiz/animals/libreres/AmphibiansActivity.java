package com.example.android.amazinganimalsquiz.animals.libreres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.amazinganimalsquiz.MainActivity;
import com.example.android.amazinganimalsquiz.MainMenuActivity;
import com.example.android.amazinganimalsquiz.R;
import com.example.android.amazinganimalsquiz.amphibians.MexicanAxolotl;

import static com.example.android.amazinganimalsquiz.R.id.amphibiansTxt;
import static com.example.android.amazinganimalsquiz.R.id.birdsBtn;
import static com.example.android.amazinganimalsquiz.R.id.fishBtn;
import static com.example.android.amazinganimalsquiz.R.id.insectsBtn;
import static com.example.android.amazinganimalsquiz.R.id.mammalsBtn;
import static com.example.android.amazinganimalsquiz.R.id.redeyedtreefrogBtn;
import static com.example.android.amazinganimalsquiz.R.id.reptilesBtn;


public class AmphibiansActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mexicanaxolotlBtn;
    private Button poisondartfrogBtn;
    private Button spottedsalamanderBtn;
    private Button redeyedtreefrogBtn;
    private ImageView ngLogo;
    private ImageView amphibiansLogo;
    private TextView amphibiansTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amphibians);
        setUpBtnAndTxt();
        MainActivity.startAnimationLogo(ngLogo);
        animationOfButtonsWhenActivityStart(Techniques.ZoomIn);

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AmphibiansActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mexicanaxolotlBtn:

                Intent intent = new Intent(AmphibiansActivity.this, MexicanAxolotl.class);

                startActivity(intent);

                break;
        }
    }


    private void setUpBtnAndTxt() {
        ngLogo = (ImageView) findViewById(R.id.ngLogo);
        amphibiansLogo = (ImageView) findViewById(R.id.amphibiansLogo);
        amphibiansTxt = (TextView) findViewById(R.id.amphibiansTxt);
        mexicanaxolotlBtn = (Button) findViewById(R.id.mexicanaxolotlBtn);
        poisondartfrogBtn = (Button) findViewById(R.id.poisondartfrogBtn);
        spottedsalamanderBtn = (Button) findViewById(R.id.spottedsalamanderBtn);
        redeyedtreefrogBtn = (Button) findViewById(R.id.redeyedtreefrogBtn);

        mexicanaxolotlBtn.setOnClickListener(this);
        poisondartfrogBtn.setOnClickListener(this);
        spottedsalamanderBtn.setOnClickListener(this);
        redeyedtreefrogBtn.setOnClickListener(this);
    }
/*                          animations                                          */

    public void btnAnimations(View view,Techniques techniques,int duration) {
        //without params
        YoYo.with(techniques).duration(duration).playOn(view);
        //with params
        //        YoYo.with(Techniques.FadeInUp)
        //
        //                .repeat(1)
        //                .playOn(view);
        //
    }

    protected void animationOfButtonsWhenActivityStart(Techniques techniques) {
        btnAnimations(amphibiansLogo, techniques, 400);
        btnAnimations(amphibiansTxt, techniques, 500);
        btnAnimations(mexicanaxolotlBtn, techniques, 600);
        btnAnimations(poisondartfrogBtn, techniques, 800);
        btnAnimations(spottedsalamanderBtn, techniques, 900);
        btnAnimations(redeyedtreefrogBtn, techniques, 1000);
    }


}