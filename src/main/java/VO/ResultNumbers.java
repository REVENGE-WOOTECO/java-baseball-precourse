package VO;

public class ResultNumbers {
    public static final int ANSWER_COUNT = 3;
    private static final int NOTHING_COUNT = 0;
    private final int strikeCnt;
    private final int ballCnt;

    public ResultNumbers(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int strikeCntValue() {
        return strikeCnt;
    }

    public int ballCntValue() {
        return ballCnt;
    }

    public boolean isAnswer() {
        return strikeCnt == ANSWER_COUNT;
    }

    public boolean isNothing() {
        return strikeCnt == 0 && ballCnt == 0;
    }

    public boolean ballAndStrike() {
        return strikeCnt > 0 && ballCnt > 0;
    }

    public boolean isOnlyBall() {
        return strikeCnt == 0 && ballCnt > 0;
    }

    public boolean isOnlyStrike() {
        return ballCnt == 0 && strikeCnt > 0;
    }
}
