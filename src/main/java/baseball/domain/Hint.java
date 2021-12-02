package baseball.domain;

public class Hint {

    private final static int MAX_STRIKE_COUNT = 3;

    private int strikeCount = 0;
    private int ballCount = 0;

    private Hint() {
    }

    public static Hint createPlayerHint(Number computerNumber, Number playerNumber) {
        Hint hint = new Hint();
        hint.countStrikeAndBall(computerNumber, playerNumber);
        return hint;
    }

    private void countStrikeAndBall(Number computerNumber, Number playerNumber) {
        for (int idx = 0; idx < playerNumber.getNumbersSize(); idx++) {
            int number = playerNumber.getNumbersValue(idx);
            if (computerNumber.hasNumberInNumbersIndex(number, idx)) {
                strikeCount++;
                continue;
            }
            if (computerNumber.containsNumberInNumbersRange(number)) {
                ballCount++;
            }
        }
    }

    public boolean checkStrikeCountAll() {
        return strikeCount == MAX_STRIKE_COUNT;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
