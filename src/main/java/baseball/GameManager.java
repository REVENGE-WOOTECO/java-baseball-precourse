package baseball;

import static utils.Constant.*;

public class GameManager {
    NumberGenerator numberGenerator = new NumberGenerator();
    MessagePrint messagePrint = new MessagePrint();
    UserInput userInput = new UserInput();
    GameResult gameResult = new GameResult();
    String answer;

    public void run() {
        answer = numberGenerator.numberGenerate();
        int strikeCnt = 0;
        int ballCnt = 0;
        boolean continueCheck = true;

        do {
            messagePrint.requestInput();
            String input = userInput.answerInput();
            strikeCnt = gameResult.getStrikeCnt(input, answer);
            ballCnt = gameResult.getBallCnt(input, answer);
            messagePrint.getResultMessage(strikeCnt, ballCnt);

            continueCheck = requestProgress(strikeCnt);

        } while (continueCheck);
    }

    public boolean requestProgress(int strikeCnt) {
        if (strikeCnt == ANSWER_COUNT) {
            messagePrint.restartRequest();
            String reply = userInput.gameOver();
            if (reply.equals(RESTART)) {
                answer = resetAnswer();
                return true;
            } else if (reply.equals(EXIT)) {
                return false;
            }
        }
        return true;
    }

    public String resetAnswer() {
        String newAnswer = numberGenerator.numberGenerate();
        return newAnswer;
    }
}
