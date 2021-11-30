package baseball;

import java.util.HashSet;

import static utils.Constant.*;

public class Validation {
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
        if (input.equals(RESTART) || input.equals(EXIT)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightDigit(String input) {
        if (input.length() != DIGIT) {
            return false;
        } else {
            return true;
        }
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
        HashSet<Character> duplicateCheck = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!duplicateCheck.contains(c)){
                duplicateCheck.add(c);
            } else {
                return true;
            }
        }
        return false;
    }
}
