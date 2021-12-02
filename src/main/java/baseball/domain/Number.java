package baseball.domain;

import static baseball.ErrorMessage.DUPLICATE_INPUT_REQUEST;
import static baseball.ErrorMessage.INVALID_INPUT_REQUEST;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MAX_LENGTH = 3;
    private static final char ZERO_CHAR = '0';

    private final List<Integer> numbers;

    private Number(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Number createRandomNumber() {
        Set<Integer> duplicateValidator = new HashSet<>();
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_LENGTH) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!duplicateValidator.contains(number)) {
                duplicateValidator.add(number);
                numbers.add(number);
            }
        }
        return new Number(numbers);
    }

    public static Number toNumber(String playerInput) {
        Set<Integer> duplicateValidator = new HashSet<>();
        List<Integer> numbers = new ArrayList<>();
        validateLength(playerInput);
        for (int i = 0; i < playerInput.length(); i++) {
            int number = playerInput.charAt(i) - ZERO_CHAR;
            validateNumber(number);
            validateDuplicateNumber(duplicateValidator, number);
            numbers.add(number);
        }
        return new Number(numbers);
    }

    private static void validateLength(String playerInput) {
        if (playerInput.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_REQUEST);
        }
    }

    private static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_INPUT_REQUEST);
        }
    }

    private static void validateDuplicateNumber(Set<Integer> duplicateValidator, int number) {
        if (duplicateValidator.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_REQUEST);
        }
        duplicateValidator.add(number);
    }

    public int getNumbersSize() {
        return numbers.size();
    }

    public int getNumbersValue(int idx) {
        return numbers.get(idx);
    }

    public boolean hasNumber(int number, int idx) {
        return numbers.get(idx).equals(number);
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}
