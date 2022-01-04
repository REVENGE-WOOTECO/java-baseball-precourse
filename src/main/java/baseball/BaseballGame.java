package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

	private static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요: ";
	private static final String MESSAGE_END_GAME = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String REQUEST_END_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
	private static final String MESSAGE_BALL = "볼";
	private static final String MESSAGE_STRIKE = "스트라이크";
	private static final String MESSAGE_NOTHING = "낫싱";

	private static final String COMMAND_RESTART_GAME = "1";
	private static final String COMMAND_END_GAME = "2";
	private static final int CONDITION_END = 3;

	public void startGame(){
		RandomNumber randomNumber = new RandomNumber();

		while (true) {
			List<Integer> answerNumber = randomNumber.makeAnswerNumber();

			boolean isAnswer;
			do {
				int inputNumber = inputNumber();

				isAnswer = compareNumber(answerNumber, inputNumber);
			} while (isAnswer == false);

			System.out.println(CONDITION_END + MESSAGE_END_GAME);

			String inputStartOver = getInputStartOver();
			if (isStartOver(inputStartOver) == false) {
				break;
			}
		}
	}

	public int inputNumber() {
		System.out.print(REQUEST_INPUT_NUMBER);
		String inputNumber = Console.readLine();

		Validator validator = new Validator(inputNumber);

		validator.handleException();

		return Integer.parseInt(inputNumber);
	}

	public boolean compareNumber(List<Integer> answerNumber, int inputNumber) {
		String answer = hint(answerNumber, inputNumber);
		System.out.println(answer);

		return answer.equals(CONDITION_END + MESSAGE_STRIKE);
	}

	public String hint(List<Integer> answerNumber, int inputNumber) {
		Count count = new Count(answerNumber, inputNumber);

		int ballCount = count.ballCount();
		int strikeCount = count.strikeCount();

		String answer = "";

		if (ballCount != 0) {
			answer += ballCount + MESSAGE_BALL;
		}
		if (strikeCount != 0) {
			if (answer.isEmpty() == false) {
				answer += " ";
			}
			answer += strikeCount + MESSAGE_STRIKE;
		}

		if (ballCount == 0 && strikeCount == 0) {
			answer = MESSAGE_NOTHING;
		}

		return answer;
	}

	public String getInputStartOver() {
		System.out.println(REQUEST_END_OR_RESTART);
		return Console.readLine();
	}

	public boolean isStartOver(String inputNumber) {
		if (inputNumber.equals(COMMAND_RESTART_GAME)) {
			return true;
		} else if (inputNumber.equals(COMMAND_END_GAME)) {
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
