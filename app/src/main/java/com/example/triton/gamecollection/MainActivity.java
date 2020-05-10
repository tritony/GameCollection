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


    public void onTappedJankenButton(View view) {

        Intent intent = new Intent(this, JankenActivity.class);
        startActivity(intent);

    }

    public void onTappedKazuateButton(View view) {

        Intent intent = new Intent(this, KazuateActivity.class);
        startActivity(intent);

    }
}
