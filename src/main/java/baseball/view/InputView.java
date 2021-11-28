package baseball.view;

import static baseball.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String gameNumberRequest() {
		System.out.print(REQUEST_INPUT_NUMBER);
		String userInput = Console.readLine();
		Validation.validateGameNumber(userInput);

		return userInput;
	}

	public static boolean endRequest() {
		System.out.println(RESTART_OR_END_GAME);
		String value = Console.readLine();
		return Validation.validateEndRequestNumber(value);
	}
}
