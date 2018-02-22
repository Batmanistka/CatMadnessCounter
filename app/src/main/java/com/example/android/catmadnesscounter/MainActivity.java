package com.example.android.catmadnesscounter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.catmadnesscounter.R;

public class MainActivity extends AppCompatActivity {
    int scoreCatA = 0;
    int scoreCatB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // saving the content of textview using the key
        outState.putInt("savText1", scoreCatA);
        outState.putInt("savText2", scoreCatB);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreCatA = savedInstanceState.getInt("savText1");
        scoreCatB = savedInstanceState.getInt("savText2");
        displayForTeamA(scoreCatA);
        displayForTeamB(scoreCatB);
    }

    public void saveNameFirstCat(View view) {
        // Takes the name from the text field A cat
        EditText editNameField = findViewById(R.id.edit_name_first_cat);
        String name = editNameField.getText().toString();
    }

    public void saveNameSecondCat(View view) {
        // Takes the name from the text field B cat
        EditText editNameField = findViewById(R.id.edit_name_second_cat);
        String name = editNameField.getText().toString();
    }

    /**
     * Displays the given score for Cat A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Cat A by 1 points.
     */
    public void addOneForCatA(View v) {
        scoreCatA = scoreCatA + 1;
        displayForTeamA(scoreCatA);
    }

    /**
     * Increase the score for Cat A by 2 points.
     */
    public void addTwoForCatA(View v) {
        scoreCatA = scoreCatA + 2;
        displayForTeamA(scoreCatA);
    }

    /**
     * Increase the score for Cat A by 3 points.
     */
    public void addThreeForCatA(View v) {
        scoreCatA = scoreCatA + 3;
        displayForTeamA(scoreCatA);
    }

    /**
     * Increase the score for Cat A by 4 points.
     */
    public void addFourForCatA(View v) {
        scoreCatA = scoreCatA + 4;
        displayForTeamA(scoreCatA);
    }

    /**
     * Displays the given score for Cat B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Cat B by 1 point.
     */

    public void addOneForCatB(View v) {
        scoreCatB = scoreCatB + 1;
        displayForTeamB(scoreCatB);
    }

    /**
     * Increase the score for Cat B by 2 point.
     */
    public void addTwoForCatB(View v) {
        scoreCatB = scoreCatB + 2;
        displayForTeamB(scoreCatB);
    }

    /**
     * Increase the score for Cat B by 3 point.
     */
    public void addThreeForCatB(View v) {
        scoreCatB = scoreCatB + 3;
        displayForTeamB(scoreCatB);
    }

    /**
     * Increase the score for Cat B by 4 point.
     */
    public void addFourForCatB(View v) {
        scoreCatB = scoreCatB + 4;
        displayForTeamB(scoreCatB);
    }

    /**
     * NewDay - reset the score for Team A and B Team.
     */
    public void newDayScore(View v) {
        displayForTeamA(scoreCatA = 0);
        displayForTeamB(scoreCatB = 0);
    }
}