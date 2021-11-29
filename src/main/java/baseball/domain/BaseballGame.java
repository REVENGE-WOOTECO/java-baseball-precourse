package baseball.domain;

public class BaseballGame {

    private final Computer computer;
    private boolean isGameEnd = false;

    private BaseballGame(Computer computer) {
        this.computer = computer;
    }

    public static BaseballGame create(Computer computer) {
        return new BaseballGame(computer);
    }

    public String roundStart(String playerInput) {
        Number playerNumber = Number.toNumber(playerInput);
        Number computerNumber = computer.getNumber();
        Hint playerHint = Hint.createPlayerHint(computerNumber, playerNumber);
        checkEndGame(playerHint);
        return playerHint.toMessage();
    }

    public void checkEndGame(Hint hint) {
        isGameEnd = hint.checkStrikeCountAll();
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }
}
