package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

	private static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요: ";
	private static final String MESSAGE_END_GAME = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String MESSAGE_BALL = "볼";
	private static final String MESSAGE_STRIKE = "스트라이크";
	private static final String MESSAGE_NOTHING = "낫싱";


	private static final int CONDITION_END = 3;

	public void startGame(){
		RandomNumber randomNumber = new RandomNumber();

		List<Integer> answerNumber = randomNumber.makeAnswerNumber();

		boolean isNotAnswer;
		do {
			Balls inputBalls = inputNumber();

			isNotAnswer = isNotAnswer(answerNumber, inputBalls);
		} while (isNotAnswer);

		System.out.println(CONDITION_END + MESSAGE_END_GAME);
	}

	public Balls inputNumber() {
		System.out.print(REQUEST_INPUT_NUMBER);
		String inputNumber = Console.readLine();

		return Balls.of(inputNumber);
	}

	public boolean isNotAnswer(List<Integer> answerNumber, Balls inputBalls) {
		String answer = hint(answerNumber, inputBalls);
		System.out.println(answer);

		return !answer.equals(CONDITION_END + MESSAGE_STRIKE);
	}

	public String hint(List<Integer> answerNumber, Balls inputBalls) {
		Count count = new Count(answerNumber, inputBalls);

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
}
