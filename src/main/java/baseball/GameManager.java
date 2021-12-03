package baseball;

import VO.InputNumbers;
import VO.ReplyNumber;

import static baseball.MessagePrint.ANSWER_COUNT;

public class GameManager {
    String answer;
    NumberGenerator numberGenerator = new NumberGenerator();
    MessagePrint messagePrint = new MessagePrint();
    UserInput userInput = new UserInput();
    GameResult gameResult = new GameResult();

    public void run() {
        answer = numberGenerator.numberGenerate();
        int strikeCnt = 0;
        int ballCnt = 0;

        do {
            messagePrint.requestInput();
            InputNumbers input = new InputNumbers(userInput.answerInput());
            strikeCnt = gameResult.getStrikeCnt(input, answer);
            ballCnt = gameResult.getBallCnt(input, answer);
            messagePrint.getResultMessage(strikeCnt, ballCnt);

        } while (requestProgress(strikeCnt));
    }

    public boolean requestProgress(int strikeCnt) {
        if (strikeCnt == ANSWER_COUNT) {
            messagePrint.restartRequest();
            ReplyNumber reply = new ReplyNumber(userInput.answerInput());
            if (reply.isRestart()) {
                answer = resetAnswer();
                return true;
            } else if (reply.isExit()) {
                return false;
            }
        }
        return true;
    }

    public String resetAnswer() {
        return numberGenerator.numberGenerate();
    }
}
