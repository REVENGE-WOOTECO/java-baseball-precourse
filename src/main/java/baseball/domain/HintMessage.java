package baseball.domain;

public class HintMessage {

    private final static int ZERO = 0;

    private final static String STRIKE = "스트라이크";
    private final static String BALL = "볼";
    private final static String NOTHING = "낫싱";

    public static String toMessage(Hint hint) {
        if (hint.getStrikeCount() == ZERO && hint.getBallCount() == ZERO) {
            return NOTHING;
        }

        if (hint.getBallCount() > ZERO && hint.getStrikeCount() == ZERO) {
            return String.format("%d%s", hint.getBallCount(), BALL);
        }

        if (hint.getStrikeCount() > ZERO && hint.getBallCount() == ZERO) {
            return String.format("%d%s", hint.getStrikeCount(), STRIKE);
        }

        return String.format("%d%s %d%s", hint.getBallCount(), BALL, hint.getStrikeCount(), STRIKE);
    }
}
