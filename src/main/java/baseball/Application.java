package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.CommandType;
import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        do {
            startGame();
        } while (checkRestartGame());
    }

    private static void startGame() {
        BaseballGame game = createBaseballGame();
        do {
            String playerInput = InputView.requestInputNumber();
            String roundResult = game.roundStart(playerInput);
            OutputView.printRoundResult(roundResult);
        } while (checkEndGame(game));
    }

    private static BaseballGame createBaseballGame() {
        Computer computer = Computer.create();
        return BaseballGame.create(computer);
    }

    private static boolean checkEndGame(BaseballGame game) {
        if (game.isGameEnd()) {
            OutputView.printGameResult();
            return false;
        }
        return true;
    }

    private static boolean checkRestartGame() {
        String playerInput = InputView.requestRestartInputNumber();
        return CommandType.of(playerInput).equals(CommandType.RESTART);
    }
}
