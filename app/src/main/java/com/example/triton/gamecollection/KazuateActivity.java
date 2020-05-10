package com.example.triton.gamecollection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.support.v7.app.AlertDialog;

/**
 * 数当てゲーム画面用 Activity
 */
public class KazuateActivity extends AppCompatActivity {

    private KazuateManager kazuateManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kazuate);
        initialize();
    }

    /**
     * 初期化処理
     */
    private void initialize() {

        TextView counter = findViewById(R.id.counter);
        counter.setText("1ターン目");

        TextView hintMessage = findViewById(R.id.hint_message);
        hintMessage.setVisibility(View.INVISIBLE);

        kazuateManager = new KazuateManager();

    }

    /**
     * ボタンを押したときの処理
     */
    public void onTappedNumButton(View view) {

        int buttonId = view.getId();
        int buttonNum = getButtonNum(buttonId);

        Boolean compareResult = kazuateManager.judge(buttonNum);
        String resultMessage = "";

        if (compareResult == null) {
            // null なら、正解だと表示する
            resultMessage = (kazuateManager.getCounter() - 1) + "ターン目で正解しました";

            new AlertDialog.Builder(this)
                    .setTitle(resultMessage)
                    .setMessage("もう一度プレイしますか？")
                    .setPositiveButton("はい", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 画面を初期化して再プレイさせる
                            initialize();

                        }
                    })
                    .setNegativeButton("いいえ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // タイトル画面に戻る
                            Intent intent = new Intent(KazuateActivity.this, MainActivity.class);
                            startActivity(intent);

                        }
                    })
                    .show();

        } else if (compareResult) {
            // true なら、不正解。また選択した値より大きい数が正解だと表示する
            TextView turnCounter = findViewById(R.id.counter);
            turnCounter.setText(kazuateManager.getCounter() + "ターン目");
            TextView hintMessage = findViewById(R.id.hint_message);
            hintMessage.setText("選択した値より、大きい数が正解です");
            hintMessage.setVisibility(View.VISIBLE);

        } else {
            // false なら、不正解。また選択した値より小さい数が正解だと表示する
            TextView turnCounter = findViewById(R.id.counter);
            turnCounter.setText(kazuateManager.getCounter() + "ターン目");
            TextView hintMessage = findViewById(R.id.hint_message);
            hintMessage.setText("選択した値より、小さい数が正解です");
            hintMessage.setVisibility(View.VISIBLE);
        }
    }

    /**
     * プレイヤーがボタンを押したときに呼ばれる
     * @param id プレイヤーが押したボタンのリソース id
     * @return プレイヤーが選んだ数字
     */
    private int getButtonNum(int id) {

        switch (id) {
            case R.id.button1:
                return 1;
            case R.id.button2:
                return 2;
            case R.id.button3:
                return 3;
            case R.id.button4:
                return 4;
            case R.id.button5:
                return 5;
            case R.id.button6:
                return 6;
            case R.id.button7:
                return 7;
            case R.id.button8:
                return 8;
            case R.id.button9:
                return 9;
            default:
                return 10;
        }

    }

}
