package baseball.domain;

import static baseball.message.SystemMessage.*;

public class BaseBallNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int baseballNumber;

    public BaseBallNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseBallNumber generateBaseBallNumber(int baseballNumber) {
        validateNumberRange(baseballNumber);
        return new BaseBallNumber(baseballNumber);
    }

    private static void validateNumberRange(int baseballNumber) {
        if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BaseBallNumber &&
            ((BaseBallNumber)obj).baseballNumber == this.baseballNumber;
    }

}