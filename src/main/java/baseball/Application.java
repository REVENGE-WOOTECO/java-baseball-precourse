package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static final String MESSAGE_END_GAME = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String MESSAGE_BALL = "볼";
	private static final String MESSAGE_STRIKE = "스트라이크";
	private static final String MESSAGE_NOTHING = "낫싱";
	private static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요: ";
	private static final String REQUEST_END_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

	private static final String COMMAND_RESTART_GAME = "1";
	private static final String COMMAND_END_GAME = "2";
	private static final int CONDITION_END = 3;
	private static final int QUESTION_NUMBER_DIGITS = 3;
	private static final char QUESTION_NUMBER_MIN = 1;
	private static final char QUESTION_NUMBER_MAX = 9;

	public static void main(String[] args) {
		Application application = new Application();

		while (true) {
			List<Integer> answerNumber = application.makeAnswerNumber();

			boolean isAnswer;
			do {
				int inputNumber = application.inputNumber();

				isAnswer = application.compareNumber(answerNumber, inputNumber);
			} while (isAnswer == false);

			System.out.println(CONDITION_END + MESSAGE_END_GAME);

			String inputStartOver = application.getInputStartOver();
			if (application.isStartOver(inputStartOver) == false) {
				break;
			}
		}
	}

	public List<Integer> makeAnswerNumber() {
		List<Integer> answerNumber = new ArrayList<>();

		while (answerNumber.size() < CONDITION_END) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);

			if (answerNumber.contains(randomNumber) == false) {
				answerNumber.add(randomNumber);
			}

		}

		return answerNumber;
	}

	public int inputNumber() {
		System.out.print(REQUEST_INPUT_NUMBER);
		String inputNumber = Console.readLine();

		handleException(inputNumber);

		return Integer.parseInt(inputNumber);
	}

	public void handleException(String inputNumber) {
		boolean isException = hasException(inputNumber);
		if (isException) {
			throw new IllegalArgumentException();
		}
	}

	public boolean hasException(String inputNumber) {
		Set<Integer> inputNumberSet = new TreeSet<>();
		char[] inputNumberSplitArray = inputNumber.toCharArray();

		for (char c : inputNumberSplitArray) {
			if (c >= QUESTION_NUMBER_MIN && c <= QUESTION_NUMBER_MAX) {
				inputNumberSet.add(Character.getNumericValue(c));
			}
		}

		return inputNumberSet.size() != QUESTION_NUMBER_DIGITS;
	}

	public boolean compareNumber(List<Integer> answerNumber, int inputNumber) {
		String answer = hint(answerNumber, inputNumber);
		System.out.println(answer);

		return answer.equals(CONDITION_END + MESSAGE_STRIKE);
	}

	public String hint(List<Integer> answerNumber, int inputNumber) {
		int ballCount = ballCount(answerNumber, inputNumber);
		int strikeCount = strikeCount(answerNumber, inputNumber);

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

	public int ballCount(List<Integer> answerNumber, int inputNumber) {
		int[] inputNumberArray = Stream.of(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).toArray();
		int count = 0;

		for (int j = 0; j < inputNumberArray.length; j++) {
			if (answerNumber.contains(inputNumberArray[j])
				&& answerNumber.get(j) != inputNumberArray[j]) {
				count++;
			}
		}

		return count;
	}

	public int strikeCount(List<Integer> answerNumber, int inputNumber) {
		int[] inputNumberArray = Stream.of(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).toArray();

		int count = 0;

		for (int i = 0; i < inputNumberArray.length; i++) {
			if (answerNumber.indexOf(inputNumberArray[i]) == i) {
				count++;
			}
		}

		return count;
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
