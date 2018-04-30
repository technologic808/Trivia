package com.example.android.trivia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaration/Initialization of variables

    int finalScore = 0;

    boolean qOneOpOne;
    boolean qOneOpTwo;
    boolean qOneOpThree;
    boolean qTwoOpOne = false;
    boolean qTwoOpTwo = false;
    boolean qTwoOpThree = false;
    boolean qThree;
    boolean qFourOpOne;
    boolean qFourOpTwo;
    boolean qFourOpThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // For Radio Buttons
    public void onButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.qOneOptionOne:
                if (checked) {
                    qOneOpOne = true;
                    qOneOpTwo = false;
                    qOneOpThree = false;
                }
                break;
            case R.id.qOneOptionTwo:
                if (checked) {
                    qOneOpOne = false;
                    qOneOpTwo = true;
                    qOneOpThree = false;
                }
                break;
            case R.id.qOneOptionThree:
                if (checked) {
                    qOneOpOne = false;
                    qOneOpTwo = false;
                    qOneOpThree = true;
                }
                break;
            case R.id.qFourOptionOne:
                if (checked) {
                    qFourOpOne = true;
                    qFourOpTwo = false;
                    qFourOpThree = false;
                }
                break;
            case R.id.qFourOptionTwo:
                if (checked) {
                    qFourOpOne = false;
                    qFourOpTwo = true;
                    qFourOpThree = false;
                }
                break;
            case R.id.qFourOptionThree:
                if (checked) {
                    qFourOpOne = false;
                    qFourOpTwo = false;
                    qFourOpThree = true;
                }
                break;
        }
    }

    // For CheckBoxes
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.qTwoOptionOne:
                if (checked) {
                    qTwoOpOne = true;
                } else {
                    qTwoOpOne = false;
                }
                break;
            case R.id.qTwoOptionTwo:
                if (checked) {
                    qTwoOpTwo = true;
                } else {
                    qTwoOpTwo = false;
                }
                break;
            case R.id.qTwoOptionThree:
                if (checked) {
                    qTwoOpThree = true;
                } else {
                    qTwoOpThree = false;
                }
                break;
        }
    }

    // On clicking the submit button
    public void submitQuiz(View view) {

        // Calculation of the final score
        // Question One

        if (qOneOpThree)
            finalScore++;

        // Question Two

        if (qTwoOpOne && qTwoOpThree && !qTwoOpTwo)
            finalScore++;

        // Question Three

        EditText questionThree = (EditText) findViewById(R.id.qThree);
        String answerThree = questionThree.getText().toString();
        qThree = answerThree.equals(getString(R.string.answerThree));

        if (qThree)
            finalScore++;

        // Question Four

        if (qFourOpThree)
            finalScore++;

        // Calculate Result

        String result;

        if (finalScore == 4)
            result = getString(R.string.Win);
        else
            result = getString(R.string.LosePart1) + " " + finalScore + " " + getString(R.string.LosePart2);

        // Display Results

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, result, duration);
        toast.show();

        // Reset Score

        finalScore = 0;
    }
}