package baseball;

import static utils.Constant.ANSWER_COUNT;
import static utils.Constant.NOTHING_COUNT;
import static utils.Message.*;

public class MessagePrint {
    public void getResultMessage(int strikeCount, int ballCount) {
        String resultMessage = "";
        if (strikeCount == ANSWER_COUNT) {
            resultMessage = strikeCount + STRIKE_MESSAGE + "\n" + CORRECT_MESSAGE;
        } else if (strikeCount == NOTHING_COUNT && ballCount == NOTHING_COUNT) {
            resultMessage = NOTHING_MESSAGE;
        } else if (strikeCount > NOTHING_COUNT && ballCount > NOTHING_COUNT) {
            resultMessage = ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE;
        } else if (strikeCount == NOTHING_COUNT) {
            resultMessage = ballCount + BALL_MESSAGE;
        } else if (ballCount == NOTHING_COUNT) {
            resultMessage = strikeCount + STRIKE_MESSAGE;
        }

        System.out.println(resultMessage);
    }

    public void requestInput() {
        System.out.print(REQUEST_INPUT_MESSAGE);
    }

    public void restartRequest() {
        System.out.println(PROGRESS_MESSAGE);
    }
}
