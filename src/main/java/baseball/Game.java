package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Util.BASE_COUNT;

public class Game {

    String play(List<Integer> input, List<Integer> computer) {
        String result = "";
        int strike = 0;
        int ball = 0;
        for (int pos = 0; pos < BASE_COUNT; pos++) {
            if (isStrike(pos, input.get(pos), computer)) {
                strike++;
            } else if (isBall(input.get(pos), computer)) {
                ball++;
            }
        }
        printResult(strike, ball);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            result = Console.readLine();
        }
        return result;
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

    private boolean isStrike(int pos, int num, List<Integer> computer) {
        return computer.indexOf(num) == pos;
    }

    private boolean isBall(int num, List<Integer> computer) {
        return computer.contains(num);
    }
}
