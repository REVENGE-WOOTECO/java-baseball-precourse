package baseball;

import baseball.view.InputView;
import baseball.view.PrintView;

public class Application {
    public static void main(String[] args) {

        Computer computer = initComputer();

        while (true) {
            String userInput = InputView.inputRequest();

            if (!computer.checkValue(userInput)) {
                continue;
            }

            PrintView.gameComplete();

            if (InputView.reStartRequest()) {
                break;
            }
            computer = initComputer();
        }
    }

    private static Computer initComputer() {
        return Computer.setValue();
    }
}
