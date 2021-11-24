package baseball.view;

public class Validation {
    public static void validate(String userInput) {

        // 길이 검증
        if (userInput.length() != 3) {
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

    private static boolean validateNumberFormat(String userInput) {
        return userInput.replaceAll("[1-9]", "").equals("");
    }

    private static boolean validateOverlap(String userInput) {
        boolean[] overlapChk = new boolean[3];
        for (int j = 0; j < 3; j++) {
            overlapChk[j] = true;

            for (int k = 0; k < 3; k++) {
                if (overlapChk[k]) continue;
                if (userInput.charAt(j) == userInput.charAt(k)) {
                    return false;
                }
            }
            overlapChk[j] = false;
        }
        return true;
    }
}