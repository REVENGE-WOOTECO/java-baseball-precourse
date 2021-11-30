package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    GameResult gameResult = new GameResult();

    @Test
    public void 스트라이크_테스트() {
        String allStrike = "123";
        String twoStrike = "124";
        String oneStrike = "159";
        String noStrike = "456";
        String answer = "123";

        assertThat(gameResult.getStrikeCnt(allStrike, answer)).isEqualTo(3);
        assertThat(gameResult.getStrikeCnt(twoStrike, answer)).isEqualTo(2);
        assertThat(gameResult.getStrikeCnt(oneStrike, answer)).isEqualTo(1);
        assertThat(gameResult.getStrikeCnt(noStrike, answer)).isEqualTo(0);
    }

    @Test
    public void 볼_테스트() {
        String allBall = "312";
        String twoBall = "932";
        String oneBall = "981";
        String noBall = "456";
        String answer = "123";

        assertThat(gameResult.getBallCnt(allBall, answer)).isEqualTo(3);
        assertThat(gameResult.getBallCnt(twoBall, answer)).isEqualTo(2);
        assertThat(gameResult.getBallCnt(oneBall, answer)).isEqualTo(1);
        assertThat(gameResult.getBallCnt(noBall, answer)).isEqualTo(0);
    }
}
