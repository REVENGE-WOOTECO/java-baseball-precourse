package baseball;

import java.util.ArrayList;
import java.util.TreeSet;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		Application application = new Application();
		ArrayList<Integer> answerNumber = application.makeAnswerNumber();
		System.out.println("정답숫자: " + answerNumber);

		System.out.print("숫자를 입력해주세요: ");
		String inputNumber = Console.readLine();
		boolean isException = application.handleException(inputNumber);

		if (isException) {
			throw new IllegalArgumentException();
		}else{

		}
	}

	/**
	 * 서로 다른 3개의 난수 구하기
	 *
	 * @return
	 */
	public ArrayList<Integer> makeAnswerNumber() {
		ArrayList<Integer> answerNumber = new ArrayList<>();

		while (true) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);

			if (answerNumber.contains(randomNumber)) {
				continue;
			} else {
				answerNumber.add(randomNumber);
			}

			if (answerNumber.size() == 3) {
				break;
			}
		}

		return answerNumber;
	}

	/**
	 * 사용자가 입력한 값 유효성체크(예외처리)
	 * 숫자가 아닌경우, 3자리가 아닌 경우, 숫자가 중복되는 경우, 0이 포함된 경우
	 *
	 * @return
	 */
	public boolean handleException(String inputNumber) {
		TreeSet<Integer> inputNumberArray = new TreeSet<>();
		char[] inputNumberSplitArray = inputNumber.toCharArray();

		for (char c : inputNumberSplitArray) {
			if (c >= '1' && c <= '9') {
				inputNumberArray.add(Character.getNumericValue(c));
			}
		}

		return inputNumberArray.size() != 3;
	}
}
