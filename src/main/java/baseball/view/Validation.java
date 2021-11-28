package baseball.view;

import static baseball.Constant.*;

public class Validation {

	public static void validateGameNumber(String userInput) {
		// 길이 검증
		if (!validateLength(userInput)) {
			throw new IllegalArgumentException(INVALID_LENGTH);
		}

		// 유효 숫자 여부 검증
		if (!validateNumberFormat(userInput)) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}

		// 중복되는 수 여부 검증
		if (!validateOverlap(userInput)) {
			throw new IllegalArgumentException(OVERLAP_OCCUR);
		}
	}

	public static boolean validateEndRequestNumber(String value) {
		if (value.equals(END_VALUE)) {
			return true;
		}
		if (value.equals(RESTART_VALUE)) {
			return false;
		}
		throw new IllegalArgumentException(INVALID_END_REQUEST);
	}

	private static boolean validateLength(String userInput) {
		return userInput.length() == MAX_BALL_COUNT;
	}

	private static boolean validateNumberFormat(String userInput) {
		return userInput.replaceAll("[1-9]", "").equals("");
	}

	private static boolean validateOverlap(String userInput) {
		boolean[] overlapCheck = new boolean[MAX_BALL_COUNT];

		for (int j = 0; j < MAX_BALL_COUNT; j++) {
			overlapCheck[j] = true;
			if (checkSameNumber(userInput, overlapCheck, j)) {
				return false;
			}
			overlapCheck[j] = false;
		}
		return true;
	}

	private static boolean checkSameNumber(String userInput, boolean[] overlapCheck, int target) {
		for (int k = 0; k < MAX_BALL_COUNT; k++) {
			if (overlapCheck[k]) {
				continue;
			}
			if (userInput.charAt(target) == userInput.charAt(k)) {
				return true;
			}
		}
		return false;
	}
}
