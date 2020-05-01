package com.guillaumegonnet.scorekeeper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";
    static final String STATE_SCORE_1_BEFORE = "Team 1 Score Before";
    static final String STATE_SCORE_2_BEFORE = "Team 2 Score Before";
    static final String STATE_NAME_1 = "Team 1 Name";
    static final String STATE_NAME_2 = "Team 2 Name";
    private int mScore1;
    private int mScore1Before; //store the last score
    private int mScore2;
    private int mScore2Before; //store the last score
    private String mTeamName1;
    private String mTeamName2;
    private TextView mScoreText1;
    private TextView mScoreText2;
    private EditText mTeamNameText1;
    private EditText mTeamNameText2;
    private Button mCancelBtn;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.guillaumegonnet.scorekeeper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreText1 = findViewById(R.id.score1);
        mScoreText2 = findViewById(R.id.score2);
        mTeamNameText1 = findViewById(R.id.team1);
        mTeamNameText2 = findViewById(R.id.team2);
        mCancelBtn = findViewById(R.id.cancel_btn);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        if (mPreferences != null) {
            mScore1 = mPreferences.getInt(STATE_SCORE_1, 0);
            mScore2 = mPreferences.getInt(STATE_SCORE_2, 0);
            mScore1Before = mPreferences.getInt(STATE_SCORE_1_BEFORE, 0);
            mScore2Before = mPreferences.getInt(STATE_SCORE_2_BEFORE, 0);
            mTeamName1 = mPreferences.getString(STATE_NAME_1, getString(R.string.team_1));
            mTeamName2 = mPreferences.getString(STATE_NAME_2, getString(R.string.team_2));

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
            mTeamNameText1.setText(mTeamName1);
            mTeamNameText2.setText(mTeamName2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    public void decreaseScore(View view) {
        mScore1Before = mScore1;
        mScore2Before = mScore2;
        mCancelBtn.setEnabled(true);

        int viewId = view.getId();

        switch (viewId) {
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam1By2:
                mScore1 -= 2;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam1By3:
                mScore1 -= 3;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam1By4:
                mScore1 -= 4;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam1By5:
                mScore1 -= 5;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam1By6:
                mScore1 -= 6;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam1By7:
                mScore1 -= 7;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.decreaseTeam2By2:
                mScore2 -= 2;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.decreaseTeam2By3:
                mScore2 -= 3;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.decreaseTeam2By4:
                mScore2 -= 4;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.decreaseTeam2By5:
                mScore2 -= 5;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.decreaseTeam2By6:
                mScore2 -= 6;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.decreaseTeam2By7:
                mScore2 -= 7;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {
        mScore1Before = mScore1;
        mScore2Before = mScore2;
        mCancelBtn.setEnabled(true);

        int viewId = view.getId();

        switch (viewId) {
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam1By2:
                mScore1 += 2;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam1By3:
                mScore1 += 3;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam1By4:
                mScore1 += 4;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam1By5:
                mScore1 += 5;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam1By6:
                mScore1 += 6;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam1By7:
                mScore1 += 7;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.increaseTeam2By2:
                mScore2 += 2;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.increaseTeam2By3:
                mScore2 += 3;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.increaseTeam2By4:
                mScore2 += 4;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.increaseTeam2By5:
                mScore2 += 5;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.increaseTeam2By6:
                mScore2 += 6;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
            case R.id.increaseTeam2By7:
                mScore2 += 7;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(STATE_SCORE_1, mScore1);
        editor.putInt(STATE_SCORE_2, mScore2);
        editor.putInt(STATE_SCORE_1_BEFORE, mScore1Before);
        editor.putInt(STATE_SCORE_2_BEFORE, mScore2Before);
        editor.putString(STATE_NAME_1, mTeamName1);
        editor.putString(STATE_NAME_2, mTeamName2);
        editor.apply();

    }

    public void resetScores(View view) {
        mScore1 = 0;
        mScoreText1.setText(String.valueOf(mScore1));
        mScore2 = 0;
        mScoreText2.setText(String.valueOf(mScore2));

        SharedPreferences.Editor editor = mPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void cancelLastAction(View view) {
        mScore2 = mScore2Before;
        mScore1 = mScore1Before;
        mScoreText1.setText(String.valueOf(mScore1));
        mScoreText2.setText(String.valueOf(mScore2));
        mCancelBtn.setEnabled(false);
    }
}
