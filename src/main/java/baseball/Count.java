package baseball;

import java.util.List;
import java.util.stream.Stream;

public class Count {

	private final int inputNumber;
	private final List<Integer> answerNumber;

	public Count(List<Integer> answerNumber, int inputNumber) {
		this.inputNumber = inputNumber;
		if(inputNumber == -1){
			throw new IllegalArgumentException();
		}
		this.answerNumber = answerNumber;
	}

	public int ballCount() {
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

	public int strikeCount() {
		int[] inputNumberArray = Stream.of(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).toArray();

		int count = 0;

		for (int i = 0; i < inputNumberArray.length; i++) {
			if (answerNumber.indexOf(inputNumberArray[i]) == i) {
				count++;
			}
		}

		return count;
	}

}
