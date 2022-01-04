package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

	private static final int CONDITION_END = 3;

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

}
