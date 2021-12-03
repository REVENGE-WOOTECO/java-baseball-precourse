package baseball;

import VO.InputNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    GameResult gameResult = new GameResult();

    @Test
    public void 스트라이크_테스트() {
        InputNumbers allStrike = new InputNumbers("123");
        InputNumbers twoStrike = new InputNumbers("124");
        InputNumbers oneStrike = new InputNumbers("159");
        InputNumbers noStrike = new InputNumbers("456");
        String answer = "123";

        assertThat(gameResult.getStrikeCnt(allStrike, answer)).isEqualTo(3);
        assertThat(gameResult.getStrikeCnt(twoStrike, answer)).isEqualTo(2);
        assertThat(gameResult.getStrikeCnt(oneStrike, answer)).isEqualTo(1);
        assertThat(gameResult.getStrikeCnt(noStrike, answer)).isEqualTo(0);
    }

    @Test
    public void 볼_테스트() {
        InputNumbers allBall = new InputNumbers("312");
        InputNumbers twoBall = new InputNumbers("312");
        InputNumbers oneBall = new InputNumbers("981");
        InputNumbers noBall = new InputNumbers("456");
        String answer = "123";

        assertThat(gameResult.getBallCnt(allBall, answer)).isEqualTo(3);
        assertThat(gameResult.getBallCnt(twoBall, answer)).isEqualTo(2);
        assertThat(gameResult.getBallCnt(oneBall, answer)).isEqualTo(1);
        assertThat(gameResult.getBallCnt(noBall, answer)).isEqualTo(0);
    }
}
