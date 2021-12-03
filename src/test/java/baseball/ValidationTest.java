package baseball;

import VO.InputNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {
    String rightNumber = "347";

    @Test
    public void 자릿수_테스트() {
        String wrongNumber = "1234";

        assertThat(InputNumbers.isRightDigit(rightNumber)).isTrue();
        assertThat(InputNumbers.isRightDigit(wrongNumber)).isFalse();
    }

    @Test
    public void 숫자_중복_테스트() {
        String duplicateNumber = "334";

        assertThat(InputNumbers.isDuplicate(rightNumber)).isFalse();
        assertThat(InputNumbers.isDuplicate(duplicateNumber)).isTrue();
    }

    @Test
    public void 숫자가_아닌_다른_입력_테스트() {
        String notNumber = "3a4";

        assertThat(InputNumbers.isNumber(rightNumber)).isTrue();
        assertThat(InputNumbers.isNumber(notNumber)).isFalse();
    }
}
