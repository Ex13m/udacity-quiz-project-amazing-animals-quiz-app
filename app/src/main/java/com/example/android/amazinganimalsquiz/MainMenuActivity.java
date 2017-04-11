package com.example.android.amazinganimalsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.amazinganimalsquiz.animals.libreres.AmphibiansActivity;
import com.example.android.amazinganimalsquiz.animals.libreres.QuizActivity;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;
import static com.example.android.amazinganimalsquiz.R.id.amphibiansBtn;
import static com.example.android.amazinganimalsquiz.R.id.nameEnter;
import static com.example.android.amazinganimalsquiz.R.id.ngLogo;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button amphibianBtn;
    private Button birdsBtn;
    private Button fishBtn;
    private Button insectsBtn;
    private Button invertibratesBtn;
    private Button mammalsBtn;
    private Button qwizblueBtn;
    private Button reptilesBtn;
    private ImageView ngLogo;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        userName = getUserNameFromMainActivity();
        setUpBtnAndTxt();
        MainActivity.startAnimationLogo(ngLogo);
        animationOfButtonsWhenActivityStart(Techniques.ZoomIn);



    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainMenuActivity.this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.amphibiansBtn:

                Intent intent = new Intent(MainMenuActivity.this, AmphibiansActivity.class);
                animationOfButtonsWhenActivityClosed(Techniques.ZoomOut);
                startActivity(intent);

                break;
            case R.id.birdsBtn:
                //Toast.makeText(this, "point for Player 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fishBtn:
                //Toast.makeText(this, "point for Player 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.insectsBtn:
                //Toast.makeText(this, "point for Player 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.invertibratesBtn:
                //Toast.makeText(this, "point for Player 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mammalsBtn:
                //Toast.makeText(this, "point for Player 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.reptilesBtn:
                //Toast.makeText(this, "point for Player 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quizBtn:
                Intent intent1 = new Intent(MainMenuActivity.this, QuizActivity.class);
                animationOfButtonsWhenActivityClosed(Techniques.ZoomOut);
                Toast.makeText(MainMenuActivity.this,
                        "Let's check the knowledge "+" "+ userName +""+"!", Toast.LENGTH_SHORT).show();
                intent1.putExtra("userName", userName);
                startActivity(intent1);

                //Toast.makeText(this, "point for Player 1", Toast.LENGTH_SHORT).show();
                break;



        }

    }

    private void setUpBtnAndTxt() {


        ngLogo = (ImageView) findViewById(R.id.ngLogo);

        amphibianBtn = (Button) findViewById(R.id.amphibiansBtn);
        birdsBtn = (Button) findViewById(R.id.birdsBtn);
        fishBtn=(Button)findViewById(R.id.fishBtn);
        insectsBtn=(Button)findViewById(R.id.insectsBtn);
        invertibratesBtn=(Button)findViewById(R.id.invertibratesBtn);
        mammalsBtn=(Button)findViewById(R.id.mammalsBtn);
        reptilesBtn=(Button)findViewById(R.id.reptilesBtn);
        qwizblueBtn=(Button)findViewById(R.id.quizBtn);
        amphibianBtn.setOnClickListener(this);
        birdsBtn.setOnClickListener(this);
        fishBtn.setOnClickListener(this);
        insectsBtn.setOnClickListener(this);
        invertibratesBtn.setOnClickListener(this);
        mammalsBtn.setOnClickListener(this);
        reptilesBtn.setOnClickListener(this);
        qwizblueBtn.setOnClickListener(this);

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
protected void animationOfButtonsWhenActivityStart(Techniques techniques){
        btnAnimations(amphibianBtn,techniques,400);
        btnAnimations(birdsBtn,techniques,500);
        btnAnimations(fishBtn,techniques,600);
        btnAnimations(insectsBtn,techniques,700);
        btnAnimations(reptilesBtn,techniques,800);
        btnAnimations(mammalsBtn,techniques,900);
        btnAnimations(invertibratesBtn,techniques,1000);
        btnAnimations(qwizblueBtn,techniques,1100);
    }
    protected void animationOfButtonsWhenActivityClosed(Techniques techniques){
        btnAnimations(amphibianBtn,techniques,400);
        btnAnimations(birdsBtn,techniques,500);
        btnAnimations(fishBtn,techniques,600);
        btnAnimations(insectsBtn,techniques,700);
        btnAnimations(reptilesBtn,techniques,800);
        btnAnimations(mammalsBtn,techniques,900);
        btnAnimations(invertibratesBtn,techniques,1000);
        btnAnimations(qwizblueBtn,techniques,1100);
    }
//**************************************************************************************************


/*                         Get user name from MainActivity                       */
    private String getUserNameFromMainActivity(){
        Intent intent= getIntent();
        return intent.getStringExtra("userName");

    }
//**************************************************************************************************
}