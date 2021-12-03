package baseball;

import static baseball.NumberGenerator.DIGIT;

public class Validation {
    public static final String RESTART = "1";
    public static final String EXIT = "2";

    public boolean validateInputNumber(String input) {

        if (!isRightDigit(input)) {
            return false;
        }

        if (!isNumber(input)) {
            return false;
        }

        if (isDuplicate(input)) {
            return false;
        }

        return true;
    }

    public boolean validateContinueNumber(String input) {
        return input.equals(RESTART) || input.equals(EXIT);
    }

    public boolean isRightDigit(String input) {
        return input.length() == DIGIT;
    }

    public boolean isNumber(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean isDuplicate(String input) {
        long count = input.chars()
                .distinct()
                .count();

        return count != input.length();
    }
}
