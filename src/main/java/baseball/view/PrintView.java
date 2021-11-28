package baseball.view;

import static baseball.Constant.*;

public class PrintView {

	public static boolean finishRequest() {
		System.out.println(SUCCESS_AND_GAME_OVER);
		return InputView.endRequest();
	}

	public static void printResult(int ball, int strike) {
		StringBuilder sb = new StringBuilder();

		if (ball != 0) {
			sb.append(ball).append(BALL).append(" ");
		}
		if (strike != 0) {
			sb.append(strike).append(STRIKE);
		}
		if (sb.length() == 0) {
			sb.append(NOTHING);
		}

		System.out.println(sb);
	}
}
