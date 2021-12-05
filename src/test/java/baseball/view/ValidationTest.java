package baseball.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Validation unit test")
class ValidationTest {

	@ParameterizedTest
	@DisplayName("게임 숫자 입력 예외 발생 테스트")
	@ValueSource(strings = {"1234", "", "23", "1", "ab", "1bc", "2a3", "111", "222", "333", "121", "102"})
	void exception_occur_in_validateGameNumber(String input) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Validation.validateGameNumber(input);
		});
	}

	@ParameterizedTest
	@DisplayName("게임 숫자 입력 성공 테스트")
	@ValueSource(strings = {"123", "456", "789", "314", "937", "149", "492"})
	void exception_no_occur_in_validateGameNumber(String input) {
		Assertions.assertDoesNotThrow(() -> {
			Validation.validateGameNumber(input);
		});
	}

	@ParameterizedTest
	@DisplayName("재시작 여부 입력 예외 발생 테스트")
	@ValueSource(strings = {"0", "3", "a", "b", "20", "-1", "00"})
	void exception_occur_in_validateEndRequestNumber(String input) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Validation.validateEndRequestNumber(input);
		});
	}

	@ParameterizedTest
	@DisplayName("재시작 여부 입력 성공 테스트")
	@ValueSource(strings = {"1", "2"})
	void exception_no_occur_in_validateEndRequestNumber(String input) {
		Assertions.assertDoesNotThrow(() -> {
			Validation.validateEndRequestNumber(input);
		});
	}
}
