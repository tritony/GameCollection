package com.example.triton.gamecollection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class JankenActivity extends AppCompatActivity {
    private JankenManager jankenManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_janken);
        jankenManager = new JankenManager();

    }

    /**
     * グー、チョキ、パーのボタンのうち、いずれかを押下したときに呼ばれる
     * @param view グー, チョキ, パー いずれかの ImageButton
     */
    public void onTappedHandButton(View view) {

        final ImageView playerHand = findViewById(R.id.player_hand);

        playerHand.setVisibility(View.VISIBLE);

        if (view.getId() == R.id.button_rock_hand) {
            jankenManager.setPlayerHand(1);
            playerHand.setImageResource(R.drawable.rock);

        } else if (view.getId() == R.id.button_scissors_hand) {
            jankenManager.setPlayerHand(2);
            playerHand.setImageResource(R.drawable.scissors);

        } else if (view.getId() == R.id.button_paper_hand) {
            jankenManager.setPlayerHand(3);
            playerHand.setImageResource(R.drawable.paper);

        }

        final TextView playerRequiredMessage = findViewById(R.id.player_required_message);
        playerRequiredMessage.setVisibility(View.GONE);

        final ImageButton buttonRockHand = findViewById(R.id.button_rock_hand);
        buttonRockHand.setVisibility(View.GONE);

        final ImageButton buttonScissorsHand = findViewById(R.id.button_scissors_hand);
        buttonScissorsHand.setVisibility(View.GONE);

        final ImageButton buttonPaperHand = findViewById(R.id.button_paper_hand);
        buttonPaperHand.setVisibility(View.GONE);

        final ImageView opponentHand = findViewById(R.id.opponent_hand);
        final int opponentResult = jankenManager.getOpponentHand();

        if (opponentResult == 1) {
            // グーの画像がセットされる
            opponentHand.setImageResource(R.drawable.rock);
        } else if (opponentResult == 2) {
            // チョキの画像がセットされる
            opponentHand.setImageResource(R.drawable.scissors);
        } else {
            // パーの画像がセットされる
            opponentHand.setImageResource(R.drawable.paper);
        }

        // 判定結果をダイアログに表示させる。
        // また、プレイヤーがゲームを再プレイするかどうかで、画面遷移先を変更する
        final Boolean judgeResult = jankenManager.judge();
        String resultMessage = "";

        if (judgeResult == null) {
            resultMessage = "引き分けです";

        } else if (judgeResult) {
            resultMessage = "あなたの勝ちです";

        } else {
            resultMessage = "あなたの負けです";
        }

        new AlertDialog.Builder(this)
                .setTitle(resultMessage)
                .setMessage("もう一度プレイしますか？")
                .setPositiveButton("はい", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        jankenManager = new JankenManager();

                        playerRequiredMessage.setVisibility(View.VISIBLE);
                        buttonRockHand.setVisibility(View.VISIBLE);
                        buttonScissorsHand.setVisibility(View.VISIBLE);
                        buttonPaperHand.setVisibility(View.VISIBLE);
                        playerHand.setVisibility(View.GONE);
                        opponentHand.setImageResource(R.drawable.rock);

                    }
                })
                .setNegativeButton("いいえ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(JankenActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                })
                .show();

    }
}
