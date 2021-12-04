package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    public void 세자리의_수가_출력된다() {
        String answer = numberGenerator.numberGenerate();
        Assertions.assertThat(answer.length()).isEqualTo(NumberGenerator.DIGIT);
    }
}
