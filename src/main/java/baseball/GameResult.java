package baseball;

import java.util.HashMap;

import static utils.Constant.DUP_COUNT;

public class GameResult {
    public int getStrikeCnt(String input, String answer) {
        int strikeCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char answerChar = answer.charAt(i);

            if (Character.compare(inputChar, answerChar) == 0) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCnt(String input, String answer) {
        HashMap<Character, Integer> ballCountMap = new HashMap<>();
        int ballCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char answerChar = answer.charAt(i);

            if (Character.compare(inputChar, answerChar) != 0) {
                ballCountMap.put(inputChar, ballCountMap.getOrDefault(inputChar, 0) + 1);
                ballCountMap.put(answerChar, ballCountMap.getOrDefault(answerChar, 0) + 1);
            }
        }

        for (Character c : ballCountMap.keySet()) {
            if (ballCountMap.get(c) == DUP_COUNT) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
