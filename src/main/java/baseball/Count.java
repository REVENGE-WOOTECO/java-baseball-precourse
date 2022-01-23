package baseball;

import java.util.List;
import java.util.stream.Stream;

public class Count {

	private final int[] inputNumberArray = new int[3];
	private final List<Integer> answerNumber;

	public Count(List<Integer> answerNumber, Balls inputBalls) {
		this.inputNumberArray[0] = inputBalls.getFirstBall(Balls.BallIndex.FIRST).getNumber();
		this.inputNumberArray[1] = inputBalls.getFirstBall(Balls.BallIndex.SECOND).getNumber();
		this.inputNumberArray[2] = inputBalls.getFirstBall(Balls.BallIndex.THIRD).getNumber();

		this.answerNumber = answerNumber;
	}

	public int ballCount() {
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
		int count = 0;

		for (int i = 0; i < inputNumberArray.length; i++) {
			if (answerNumber.indexOf(inputNumberArray[i]) == i) {
				count++;
			}
		}

		return count;
	}

}
