package baseball;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.PrintView;

public class Application {
	public static void main(String[] args) {
		Computer computer = Computer.initialValue();
		boolean restartChk = true;

		while (restartChk) {
			String userInput = InputView.gameNumberRequest();

			if (!computer.checkValue(userInput)) {
				continue;
			}

			restartChk = !(PrintView.finishRequest());
			computer.resetValue();
		}

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

		/**
		 * PrintView.finishRequest()
		 * @return true -> game over
		 * @return false -> game re-start
		 */

		boolean chk = true;

		// case 1: finishRequest 반환값을 기반으로 break
		while (true) {
			if (PrintView.finishRequest()) {
				break;
			}
		}

		// case 2: chk 를 finishRequest 반환값으로 갱신
		while (chk) {
			chk = !(PrintView.finishRequest());
		}

		//        while (true) {
		//            String userInput = InputView.gameNumberRequest();
		//
		//            if (!computer.checkValue(userInput)) {
		//                continue;
		//            }
		//
		//            PrintView.gameComplete();
		//
		//            if (!InputView.endRequest()) {
		//                break;
		//            }
		//            computer.resetValue();
		//        }
	}
}
