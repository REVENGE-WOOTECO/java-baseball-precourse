package baseball;

import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Constant.*;

public class Computer {

    private String value;

    private Computer(String value) {
        this.value = value;
    }

    public static Computer initialValue() {
        return new Computer(getRandomValue());
    }

    public void resetValue() {
        value = getRandomValue();
    }

    public boolean checkValue(String check) {
        if (value.equals(check)) {
            PrintView.printResult(0, MAX_BALL_COUNT);
            return true;
        }

        makeFeedback(check);
        return false;
    }

    private void makeFeedback(String check) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < MAX_BALL_COUNT; i++) {
            if (value.charAt(i) == check.charAt(i)) {
                strike++;
                continue;
            }
            if (value.contains(check.charAt(i) + "")) {
                ball++;
            }
        }
        PrintView.printResult(ball, strike);
    }

    public static String getRandomValue() {
        StringBuilder sb = new StringBuilder();

        while (sb.length() != MAX_BALL_COUNT) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
            if (!sb.toString().contains(randomNumber)) {
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }

}
