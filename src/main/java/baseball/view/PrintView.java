package baseball.view;

import static baseball.Constant.*;

public class PrintView {

	public static boolean finishRequest() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		return InputView.endRequest();
	}

	public static void printResult(int ball, int strike) {
		StringBuilder sb = new StringBuilder();

		if (ball != 0) {
			sb.append(ball).append("볼").append(BLANK);
		}
		if (strike != 0) {
			sb.append(strike).append("스트라이크");
		}
		if (sb.length() == 0) {
			sb.append("낫싱");
		}

		System.out.println(sb);
	}
}
