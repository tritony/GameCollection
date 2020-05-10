package com.example.triton.gamecollection;
import java.util.Random;

/**
 * じゃんけんの手を生成や、判定など、じゃんけんそのものの処理を担当する
 */
public class JankenManager {

    // 相手(CPU)の手
    // 1: グー, 2: チョキ, 3: パー
    private int opponentHand;
    // プレイヤーの手
    private int playerHand;

    public JankenManager() {

        Random random = new Random();
        opponentHand = random.nextInt(3) + 1;

    }

    public int getOpponentHand() {

        return opponentHand;
    }

    public void setPlayerHand(int hand) {

        this.playerHand = hand;

    }

    /**
     * 判定処理をする
     *
     * @return プレイヤーが勝ったら true, 負けたら false, 引き分けは null
     */
    public Boolean judge() {

        if (playerHand == opponentHand) {
            return null;

        } else if (opponentHand - playerHand == 1) {
            return true;

        } else if (opponentHand - playerHand == 2) {
            return false;

        } else if (opponentHand - playerHand == -1) {
            return false;

        } else if (opponentHand - playerHand == -2) {
            return true;

        }
        return null;
    }
}
