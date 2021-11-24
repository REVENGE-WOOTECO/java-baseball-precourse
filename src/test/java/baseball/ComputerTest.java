package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Computer Unit Test")
class ComputerTest {

    @Test
    @DisplayName("랜덤 숫자를 추출 후 1000회 검증")
    void extractRandomValue() {
        for (int i = 0; i < 1000; i++) {
            Assertions.assertDoesNotThrow(() -> {
                String randomValue = Computer.getRandomValue();
                boolean[] chk = new boolean[3];
                for (int j = 0; j < 3; j++) {
                    chk[j] = true;

                    for (int k = 0; k < 3; k++) {
                        if (chk[k]) continue;
                        if (randomValue.charAt(j) == randomValue.charAt(k)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    chk[j] = false;
                }
            });
        }
    }
}