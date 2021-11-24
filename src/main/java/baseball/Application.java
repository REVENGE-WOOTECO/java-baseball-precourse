package baseball;

import baseball.view.InputView;
import baseball.view.PrintView;

public class Application {
    public static void main(String[] args) {

        Computer computer = initComputer();
        while (true) {
//            System.out.println("computer = " + computer.getValue());
            String userInput = InputView.inputRequest();

            if (!computer.checkValue(userInput)) {
                continue;
            }

            PrintView.gameComplete();

            if (InputView.endRequest()) {
                break;
            }
            computer = initComputer();
        }
    }

    private static Computer initComputer() {
        return Computer.initialValue();
    }
}
