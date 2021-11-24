package baseball.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Validation unit test")
class ValidationTest {

    @ParameterizedTest
    @DisplayName("예외 발생 테스트")
    @ValueSource(strings = {"1234", "", "23", "1", "ab", "1bc", "2a3", "111", "222", "333", "121", "102"})
    void exceptionOccur(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           Validation.validate(input);
        });
    }

    @ParameterizedTest
    @DisplayName("성공 테스트")
    @ValueSource(strings = {"123", "456", "789", "314", "937", "149", "492"})
    void exceptionNoOccur(String input) {
        Assertions.assertDoesNotThrow(() -> {
            Validation.validate(input);
        });
    }
}