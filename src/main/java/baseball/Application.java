package baseball;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.PrintView;

public class Application {
	public static void main(String[] args) {
		Computer computer = Computer.initialValue();

		while (true) {
			String userInput = InputView.gameNumberRequest();

			if (!computer.checkValue(userInput)) {
				continue;
			}

			if (PrintView.finishRequest()) {
				break;
			}
			computer.resetValue();
		}
	}
}
