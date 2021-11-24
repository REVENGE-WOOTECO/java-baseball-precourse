package baseball;

import baseball.view.InputView;
import baseball.view.PrintView;

public class Application {

    public static void main(String[] args) {
        Computer computer = Computer.initialValue();

        while (true) {
            String userInput = InputView.inputRequest();

            if (!computer.checkValue(userInput)) {
                continue;
            }

            PrintView.gameComplete();

            if (InputView.endRequest()) {
                break;
            }
            computer.resetValue();
        }
    }
}
