package baseball;

import java.util.Set;
import java.util.TreeSet;

public class Validator {

	private static final int QUESTION_NUMBER_DIGITS = 3;
	private static final char QUESTION_NUMBER_MIN = '1';
	private static final char QUESTION_NUMBER_MAX = '9';

	private final String inputNumber;

	public Validator(String inputNumber) {
		this.inputNumber = inputNumber;
	}

	public void handleException() {
		boolean isException = hasException();
		if (isException) {
			throw new IllegalArgumentException();
		}
	}

	public boolean hasException() {
		Set<Integer> inputNumberSet = new TreeSet<>();
		char[] inputNumberSplitArray = inputNumber.toCharArray();

		for (char c : inputNumberSplitArray) {
			if (c >= QUESTION_NUMBER_MIN && c <= QUESTION_NUMBER_MAX) {
				inputNumberSet.add(Character.getNumericValue(c));
			}
		}

		return inputNumberSet.size() != QUESTION_NUMBER_DIGITS;
	}
}
