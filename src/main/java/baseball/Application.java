package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	private static final String REQUEST_END_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
	private static final String COMMAND_RESTART_GAME = "1";
	private static final String COMMAND_END_GAME = "2";

	public static void main(String[] args) {
		do{
			BaseballGame baseballGame = new BaseballGame();
			baseballGame.startGame();
		}while(isNotStartOver(getInputStartOver()));
	}

	public static String getInputStartOver() {
		System.out.println(REQUEST_END_OR_RESTART);
		return Console.readLine();
	}

	public static boolean isNotStartOver(String inputNumber) {
		if (inputNumber.equals(COMMAND_RESTART_GAME)) {
			return true;
		} else if (inputNumber.equals(COMMAND_END_GAME)) {
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
