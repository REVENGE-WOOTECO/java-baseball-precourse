package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {
    Validation validation = new Validation();

    String rightNumber = "347";

    @Test
    public void 자릿수_테스트() {
        String wrongNumber = "1234";

        assertThat(validation.isRightDigit(rightNumber)).isTrue();
        assertThat(validation.isRightDigit(wrongNumber)).isFalse();
    }

    @Test
    public void 숫자_중복_테스트() {
        String duplicateNumber = "334";

        assertThat(validation.isDuplicate(rightNumber)).isFalse();
        assertThat(validation.isDuplicate(duplicateNumber)).isTrue();
    }

    @Test
    public void 숫자가_아닌_다른_입력_테스트() {
        String notNumber = "3a4";

        assertThat(validation.isNumber(rightNumber)).isTrue();
        assertThat(validation.isNumber(notNumber)).isFalse();
    }
}
