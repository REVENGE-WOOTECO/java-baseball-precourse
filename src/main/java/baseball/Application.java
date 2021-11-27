package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		Application application = new Application();
		ArrayList<Integer> answerNumber = application.makeAnswerNumber();
	}

	/**
	 * 서로 다른 3개의 난수 구하기
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
}
