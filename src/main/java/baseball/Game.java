package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private final Util util;
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private static final String NOTHING = "nothing";

    public Game(Util util) {
        this.util = util;
    }

    public String play(List<Integer> input, List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        for (int pos = 0; pos < util.getBaseCount(); pos++) {
            String judgeResult = judgeResult(pos, input.get(pos), computer);
            if (judgeResult.equals(STRIKE)) {
                strike++;
            } else if (judgeResult.equals(BALL)) {
                ball++;
            }
        }
        printResult(strike, ball);
        if (hasSuccess(strike)) {
            return Console.readLine();
        }
        return "";
    }

    private boolean hasSuccess(int strike) {
        if (strike == util.getBaseCount()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }


    private void printResult(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    private String judgeResult(int pos, int num, List<Integer> computer) {
        if (computer.indexOf(num) == pos) {
            return STRIKE;
        } else if (computer.contains(num)) {
            return BALL;
        }
        return NOTHING;
    }
}
