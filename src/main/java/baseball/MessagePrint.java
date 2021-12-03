package baseball;

import VO.ResultNumbers;

public class MessagePrint {
    public static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String PROGRESS_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";

    public void getResultMessage(ResultNumbers result) {
        String resultMessage = "";
        if (result.isAnswer()) {
            resultMessage = answerMessage(result);
        }

        if (result.isNothing()) {
            resultMessage = nothingMessage(result);
        }

        if (result.ballAndStrike()) {
            resultMessage = ballAndStrikeMessage(result);
        }

        System.out.println(resultMessage);
    }

    public void requestInput() {
        System.out.print(REQUEST_INPUT_MESSAGE);
    }

    public void restartRequest() {
        System.out.println(PROGRESS_MESSAGE);
    }

    public String answerMessage(ResultNumbers result) {
        return result.strikeCntValue() + STRIKE_MESSAGE + "\n" + CORRECT_MESSAGE;
    }

    public String nothingMessage(ResultNumbers result) {
        return NOTHING_MESSAGE;
    }

    public String ballAndStrikeMessage(ResultNumbers result) {
        if (result.isOnlyStrike()) {
            return result.strikeCntValue() + STRIKE_MESSAGE;
        }

        if (result.isOnlyBall()) {
            return result.ballCntValue() + BALL_MESSAGE;
        }

        return result.ballCntValue() + BALL_MESSAGE + " " + result.strikeCntValue() + STRIKE_MESSAGE;
    }
}
