package baseball.domain;

public class Hint {

    private final static int MAX_STRIKE_COUNT = 3;
    private final static int ZERO = 0;

    private final static String STRIKE = "스트라이크";
    private final static String BALL = "볼";
    private final static String NOTHING = "낫싱";

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
            if (computerNumber.hasNumber(playerNumber.getNumbersValue(idx), idx)) {
                strikeCount++;
                continue;
            }
            if (computerNumber.containsNumber(playerNumber.getNumbersValue(idx))) {
                ballCount++;
            }
        }
    }

    public boolean checkStrikeCountAll() {
        return strikeCount == MAX_STRIKE_COUNT;
    }

    public String toMessage() {
        if (strikeCount == ZERO && ballCount == ZERO) {
            return NOTHING;
        } else if (strikeCount == ZERO) {
            return String.format("%d%s", ballCount, BALL);
        } else if (ballCount == ZERO) {
            return String.format("%d%s", strikeCount, STRIKE);
        } else {
            return String.format("%d%s %d%s", ballCount, BALL, strikeCount, STRIKE);
        }
    }
}
