package baseball.view;

import static baseball.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String gameNumberRequest() {
		System.out.print("숫자를 입력해주세요 : ");
		String userInput = Console.readLine();
		Validation.validateGameNumber(userInput);

		return userInput;
	}

	public static boolean endRequest() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String value = Console.readLine();
		return Validation.validateEndRequestNumber(value);
	}
}
