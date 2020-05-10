package com.example.triton.gamecollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * "じゃんけん" と表示されたボタンを押下すると、じゃんけんゲームが始まる
     */
    public void onTappedJankenButton(View view) {

        Intent intent = new Intent(this, JankenActivity.class);
        startActivity(intent);

    }

    /**
     * "数当て" と表示されたボタンを押下すると、数当てゲームが始まる
     */
     public void onTappedKazuateButton(View view) {

        Intent intent = new Intent(this, KazuateActivity.class);
        startActivity(intent);

    }
}
