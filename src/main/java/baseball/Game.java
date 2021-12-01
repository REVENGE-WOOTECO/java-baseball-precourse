package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final Util util;
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private static final String NOTHING = "nothing";

    public Game(Util util) {
        this.util = util;
    }

    public String play(List<Integer> input, List<Integer> computer) {
        Map<String, Integer> pointMap = calculatePoint(input, computer);
        int strikeCount = pointMap.get(STRIKE);
        int ballCount = pointMap.get(BALL);
        printPoint(strikeCount, ballCount);
        if (hasSuccess(strikeCount)) {
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


    private void printPoint(int strikeCount, int ballCount) {
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
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

    private Map<String, Integer> calculatePoint(List<Integer> input, List<Integer> computer) {
        Map<String, Integer> pointMap = new HashMap<>();
        Integer strikeCount = 0;
        Integer ballCount = 0;
        for (int pos = 0; pos < util.getBaseCount(); pos++) {
            String judgeResult = judgeResult(pos, input.get(pos), computer);
            if (judgeResult.equals(STRIKE)) {
                strikeCount++;
            } else if (judgeResult.equals(BALL)) {
                ballCount++;
            }
        }
        pointMap.put(STRIKE, strikeCount);
        pointMap.put(BALL, ballCount);
        return pointMap;
    }
}
