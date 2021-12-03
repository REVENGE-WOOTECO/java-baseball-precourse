package VO;

import static baseball.NumberGenerator.DIGIT;

public class InputNumbers {
    private final String value;

    public InputNumbers(String inputNumbers) {
        if (!validateInputNumber(inputNumbers)) {
            throw new IllegalArgumentException();
        }
        this.value = inputNumbers;
    }

    public static boolean isRightDigit(String input) {
        return input.length() == DIGIT;
    }

    public static boolean isNumber(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicate(String input) {
        long count = input.chars()
                .distinct()
                .count();

        return count != input.length();
    }

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

    public String value() {
        return value;
    }
}
