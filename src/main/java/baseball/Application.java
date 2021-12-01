package baseball;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		Application application = new Application();

		while (true) {
			ArrayList<Integer> answerNumber = application.makeAnswerNumber();

			boolean isAnswer;
			do {
				int inputNumber = application.inputNumber();

				isAnswer = application.compareNumber(answerNumber, inputNumber);
			} while (isAnswer == false);

			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

			String inputStartOver = application.getInputStartOver();
			if (application.isStartOver(inputStartOver) == false) {
				break;
			}
		}
	}

	public ArrayList<Integer> makeAnswerNumber() {
		ArrayList<Integer> answerNumber = new ArrayList<>();

		while (answerNumber.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);

			if (answerNumber.contains(randomNumber) == false) {
				answerNumber.add(randomNumber);
			}

		}

		return answerNumber;
	}

	public int inputNumber() {
		System.out.print("숫자를 입력해주세요: ");
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
		TreeSet<Integer> inputNumberArray = new TreeSet<>();
		char[] inputNumberSplitArray = inputNumber.toCharArray();

		for (char c : inputNumberSplitArray) {
			if (c >= '1' && c <= '9') {
				inputNumberArray.add(Character.getNumericValue(c));
			}
		}

		return inputNumberArray.size() != 3;
	}

	public boolean compareNumber(ArrayList<Integer> answerNumber, int inputNumber) {
		String answer = hint(answerNumber, inputNumber);
		System.out.println(answer);

		return answer.equals("3스트라이크");
	}

	public String hint(ArrayList<Integer> answerNumber, int inputNumber) {
		int ballCount = ballCount(answerNumber, inputNumber);
		int strikeCount = strikeCount(answerNumber, inputNumber);

		String answer = "";

		if (ballCount != 0) {
			answer += ballCount + "볼";
		}
		if (strikeCount != 0) {
			if (answer.isEmpty() == false) {
				answer += " ";
			}
			answer += strikeCount + "스트라이크";
		}

		if (ballCount == 0 && strikeCount == 0) {
			answer = "낫싱";
		}

		return answer;
	}

	public int ballCount(ArrayList<Integer> answerNumber, int inputNumber) {
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

	public int strikeCount(ArrayList<Integer> answerNumber, int inputNumber) {
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
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return Console.readLine();
	}

	public boolean isStartOver(String inputNumber) {
		if (inputNumber.equals("1")) {
			return true;
		} else if (inputNumber.equals("2")) {
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
