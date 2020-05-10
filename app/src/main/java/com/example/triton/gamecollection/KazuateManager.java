package com.example.triton.gamecollection;

import java.util.Random;

/**
 * 数当てゲームのロジック
 */
public class KazuateManager {

    // ゲームのターン数
    private int counter;
    // 相手(CPU) が選択した数字(1 ~ 10)
    private int answer;

    public KazuateManager() {
        counter = 1;

        Random rand = new Random();
        answer = rand.nextInt(10) + 1;
    }

    /**
     * プレイヤーが選択した数字と、相手(CPU)が選択した数字を照合する
     * @param playerSelectNum プレイヤーが選択した数字
     * @return 正解: null, 値が大きい: true, 値が小さい: false
     */
    public Boolean judge(int playerSelectNum) {

        counter++;

        if (answer == playerSelectNum) {
            return null;

        } else if (answer > playerSelectNum) {
            return true;

        } else {
            return false;

        }
    }

    public int getCounter() {
        return counter;
    }
}
