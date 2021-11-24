package baseball.view;

import static baseball.Constant.MAX_BALL_COUNT;

public class Validation {

    public static void validate(String userInput) {
        // 길이 검증
        if (!validateLength(userInput)) {
            throw new IllegalArgumentException();
        }

        // 숫자 여부 검증
        if (!validateNumberFormat(userInput)) {
            throw new IllegalArgumentException();
        }

        // 중복되는 수 여부 검증
        if (!validateOverlap(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateLength(String userInput) {
        return userInput.length() == MAX_BALL_COUNT;
    }

    private static boolean validateNumberFormat(String userInput) {
        return userInput.replaceAll("[1-9]", "").equals("");
    }

    private static boolean validateOverlap(String userInput) {
        boolean[] overlapChk = new boolean[MAX_BALL_COUNT];

        for (int j = 0; j < MAX_BALL_COUNT; j++) {
            overlapChk[j] = true;
            if (checkSameNumber(userInput, overlapChk, j)) {
                return false;
            }
            overlapChk[j] = false;
        }
        return true;
    }

    private static boolean checkSameNumber(String userInput, boolean[] overlapChk, int target) {
        for (int k = 0; k < MAX_BALL_COUNT; k++) {
            if (overlapChk[k]) continue;
            if (userInput.charAt(target) == userInput.charAt(k)) {
                return true;
            }
        }
        return false;
    }
}