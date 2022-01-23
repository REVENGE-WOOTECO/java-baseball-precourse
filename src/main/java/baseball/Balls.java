package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {

	// 클라이언트가 0이 첫번째 공인지, 1이 첫번째 공인지 헷갈리지 않도록 상수화 해줍시다
	public enum BallIndex {
		FIRST(0),
		SECOND(1),
		THIRD(2);

		private final int index;

		BallIndex(int index) {
			this.index = index;
		}

		public int getIndex() {
			return index;
		}
	}

	private static final int BALLS_SIZE = 3;

	private final List<Ball> values;

	private Balls(List<Ball> values) {
		this.values = values;
	}

	// 대신 제가 원하는 방법대로 클래스를 만들도록 강요하는 정적 팩토리 메서드를 제공합니다.
	public static Balls of(String numbers) {
		if (numbers.length() != BALLS_SIZE) {
			throw new IllegalArgumentException(String.format("숫자는 %d글자 여야 합니다.", BALLS_SIZE));
		}
		// 보통 스트림으로 처리하지만 이해를 돕기위해 for문으로 작성하였습니다
		List<String> ballNumbers = Arrays.asList(numbers.split(""));
		List<Ball> values = new ArrayList<>();
		for (String ballNumber : ballNumbers) {
			values.add(new Ball(ballNumber));
		}

		return new Balls(values);
	}

	//FIRST, SECOND, THIRD 중 하나로 공을 찾아갑니다.
	public Ball getFirstBall(BallIndex index) {
		return values.get(index.getIndex());
	}
}
