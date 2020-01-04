package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    public static int finalScoreNum = 0;
    public static int highest = 0;
    private int[] scoreArray = new int[0];
    private TextView finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        finalScore = findViewById(R.id.score);
        Button tryAgain = findViewById(R.id.retryButton);
        highScore();

        TriviaMainPage.score = 0;
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextLayout();
            }
        });




    }

    private void highScore() {
        if (highest == 0) {
            highest = TriviaMainPage.score;
            finalScore.setText(Integer.toString(highest));
        }

        if (highest > TriviaMainPage.score) {
            finalScore.setText(Integer.toString(TriviaMainPage.score));
        } else {
            highest = TriviaMainPage.score;
            finalScore.setText(Integer.toString(highest));
        }
    }

//    private void storeScores() {
//        int[] newScoreArray = new int[scoreArray.length + 1];
//        newScoreArray[scoreArray.length - 1] = TriviaMainPage.score;
//        scoreArray = newScoreArray;
//    }
//
//    private int checkHighest() {
//        int highest = 0;
//        for (int i : scoreArray) {
//            if (i > highest) {
//                highest = i;
//            }
//        }
//        return highest;
//    }



    public void openNextLayout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
