package com.example.android.amazinganimalsquiz.animals.libreres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.amazinganimalsquiz.MainMenuActivity;
import com.example.android.amazinganimalsquiz.R;
public class QuizActivity extends AppCompatActivity {

    private String userName;
    private int Score;
    private EditText bearNameTxt;
    private Button showResultBtn;
    private Button tryAgainBtn;
    private TextView resultTxt;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;


    private static final String TAG = "quizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setUp();
        animalNameControl();
        checkBoxAnswerControl();
    }


    //methods for save variables in Landscape
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("User name", userName);
        outState.putInt("Score", Score);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        userName = savedInstanceState.getString("User name");
        Score = savedInstanceState.getInt("Score");

    }


    //Radio Button control question 1
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yesRbtn:
                if (checked)
                    Score=Score+1;
//for debug
//                Log.d(TAG,"onRadioButtonClicked1"+Score );
//                Toast.makeText(QuizActivity.this, "Score" + " "  + Score, Toast.LENGTH_SHORT).show();
                break;
            case R.id.noRbtn:
                if (checked)
                    break;

        }
    }

    //Radio Button control question 3
    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {

            case R.id.fishRbtn:
                if (checked)
                    Score=Score+1;
//for debug
//                Toast.makeText(QuizActivity.this, "Score" + " "  + Score, Toast.LENGTH_SHORT).show();
//                Log.d(TAG,"onRadioButtonClicked2" + Score );
                break;
            case R.id.crocodileRbtn:
                if (checked)

                    break;
        }
    }

//    method for control animal name in question 3
        public void animalNameControl() {
            bearNameTxt.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    boolean consumed = false;

                    //action key down (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        if ((bearNameTxt.getText().toString()).equalsIgnoreCase("bear")) {
                            Score=Score+1;
//for debug
//                          Log.d(TAG,"animalNameControl"+Score );
//                          Toast.makeText(QuizActivity.this, "ответ" + " " + bearNameTxt.getText().toString() + " " + Score, Toast.LENGTH_SHORT).show();
                        }
                        consumed = true;
                    }

                    return consumed;
                }
            });
        }

    //checkbox control
    public int checkBoxAnswerControl(){

        if(checkBox1.isChecked()&& checkBox2.isChecked()&&
           checkBox3.isChecked()&&checkBox4.isChecked()&&
           checkBox6.isChecked()){Score=Score+1;}
        return Score;
    }




    //return to previous activity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(QuizActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }

    //get user name from MainMenuActivity
    public String getUserNameFromMainActivity() {
        Intent intent = getIntent();
        return intent.getStringExtra("userName");
    }

    //btn show results method
    public void onShowResultsClicked(View view) {
        checkBoxAnswerControl();
//for debug
//        Toast.makeText(QuizActivity.this, "Score" + " "  + Score, Toast.LENGTH_SHORT).show();
        if (Score == 4) {
            Toast.makeText(QuizActivity.this, "You're just a genius in th world of animals!", Toast.LENGTH_SHORT).show();
            resultTxt.setText("You result" + " " + userName + "" + ":" + " " + Score + " " + " correct answers on 4 questions. " +
                    "You're just a genius in th world of animals");


        } else if (Score == 2 || Score == 3) {
            Toast.makeText(QuizActivity.this, "You know a lot of animals, but not all.", Toast.LENGTH_SHORT).show();
            resultTxt.setText("You result" + " " + userName + "" + ":" + " " + Score + " " + " correct answers on 4 questions. " +
                    "You know a lot of animals, but not all.");

        } else {
            Toast.makeText(QuizActivity.this, "You're just down, man!", Toast.LENGTH_SHORT).show();
            resultTxt.setText("You result" + " " + userName + "" + ":" + " " + Score + " " + " correct answers on 4 questions. " +
                    "You're just down, man!");
        }
        restartParams();
    }

    //btn try again method
    public void onTryAgainClicked(View view) {
        Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
        startActivity(intent);

    }

    //restart params
    public void restartParams(){
        Score=0;
        RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
        radioGroup1.clearCheck();
        RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
        radioGroup2.clearCheck();
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        checkBox5.setChecked(false);
        checkBox6.setChecked(false);
        bearNameTxt.setText("");

    }

    //setup variables
    public void setUp(){
        Toast.makeText(QuizActivity.this,
                "Let's check the knowledge "+" "+ userName +""+"!", Toast.LENGTH_SHORT).show();
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox4=(CheckBox)findViewById(R.id.checkBox4);
        checkBox5=(CheckBox)findViewById(R.id.checkBox5);
        checkBox6=(CheckBox)findViewById(R.id.checkBox6);
        resultTxt = (TextView) findViewById(R.id.resultTxt);
        showResultBtn = (Button) findViewById(R.id.showResultsBtn);
        tryAgainBtn = (Button) findViewById(R.id.tryAgainBtn);
        Score=0;
        bearNameTxt = (EditText) findViewById(R.id.bearNameTxt);
        userName = getUserNameFromMainActivity();
    }


}
