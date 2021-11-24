package baseball.view;

import static baseball.Constant.RE_GAME;
import static baseball.Constant.SUCCESS_AND_GAME_OVER;

public class PrintView {

    public static void gameComplete() {
        System.out.println(SUCCESS_AND_GAME_OVER);
        System.out.println(RE_GAME);
    }

    public static void printResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();

        if (ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

}
