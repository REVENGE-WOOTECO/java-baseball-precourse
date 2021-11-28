package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InputView Unit Test")
class InputViewTest {

    @ParameterizedTest
    @DisplayName("정상적인 숫자가 아닌 것 찾기")
    @CsvSource({"123, true", "456, true", "abc, false", "ab2, false", "dkf, false"})
    void noNumber(String input, boolean result) {
//        Assertions.assertThat(InputView.validateNumberFormat(input)).isEqualTo(result);
    }


}