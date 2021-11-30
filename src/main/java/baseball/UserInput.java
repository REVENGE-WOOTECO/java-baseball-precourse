package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    Validation validation = new Validation();
    String input;

    public String answerInput() throws IllegalArgumentException {
        input = Console.readLine();
        if (!validation.validateInputNumber(input)) {
            throw new IllegalArgumentException();
        } else {
            return input;
        }
    }

    public String gameOver() throws IllegalArgumentException {
        input = Console.readLine();
        if (!validation.validateContinueNumber(input)) {
            throw new IllegalArgumentException();
        } else {
            return input;
        }
    }
}
