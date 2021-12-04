package baseball;

import VO.InputNumbers;

import java.util.HashMap;

public class GameResult {
    private static final int DUP_COUNT = 2;

    public int getStrikeCnt(InputNumbers inputNumbers, String answer) {
        int strikeCount = 0;
        String input = inputNumbers.value();

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char answerChar = answer.charAt(i);

            if (Character.compare(inputChar, answerChar) == 0) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCnt(InputNumbers inputNumbers, String answer) {
        HashMap<Character, Integer> ballCountMap = new HashMap<>();
        int ballCount = 0;
        String input = inputNumbers.value();

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
