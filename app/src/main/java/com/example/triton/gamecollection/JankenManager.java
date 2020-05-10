package com.example.triton.gamecollection;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JankenManager {

    private int opponentHand;
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

    public static void main(String[] args) {

        System.out.println("じゃん、けん...");
        System.out.println("数字を入力して下さい。");
        System.out.println("1: グー, 2: チョキ, 3: パー");

        Random random = new Random();

        int randomValue = random.nextInt(2) + 1;

        Scanner sc = new Scanner(System.in);

        int line = 0;

        try {
            line =  sc.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("1 ~ 3 (半角文字)を入力して下さい。");
            return;
        }

        System.out.println("あなた: " + convertNumberToHand(line));
        System.out.println("相手: " + convertNumberToHand(randomValue));

        if (randomValue == 1) {

            if (line == 1) {
                System.out.println("あいこ");
            }

            else if (line == 2) {
                System.out.println("負け");
            }

            else if (line == 3) {
                System.out.println("勝ち");
            }

            else {

                System.out.println("1 ~ 3 (半角文字)を入力して下さい。");
            }
        }

        else if (randomValue == 2) {

            if (line == 1) {
                System.out.println("勝ち");
            }

            else if (line == 2) {
                System.out.println("あいこ");
            }

            else if (line == 3) {
                System.out.println("負け");
            }
            else {
                System.out.println("1 ~ 3 (半角文字)を入力して下さい。");
            }
        }
        else if (randomValue == 3) {

            if (line == 1) {
                System.out.println("負け");
            }

            else if (line == 2) {
                System.out.println("勝ち");
            }

            else if (line == 3) {
                System.out.println("あいこ");
            }

            else {
                System.out.println("1 ~ 3 (半角文字)を入力して下さい。");

            }
        }

    }

    public static String convertNumberToHand(int num) {

        if ( num == 1 ) {

            return "グー";

        }

        else if ( num == 2 ) {

            return "チョキ";
        }

        else if ( num == 3 ) {

            return "パー";
        }

        else {
            return "";
        }
    }

}
