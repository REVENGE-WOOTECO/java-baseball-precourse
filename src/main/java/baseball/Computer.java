package baseball;

import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private String value;

    private Computer(String value) {
        this.value = value;
    }

    public static Computer initialValue() {
        return new Computer(getRandomValue());
    }

    public String getValue() {
        return value;
    }

    public boolean checkValue(String check) {
        if (value.equals(check)) {
            PrintView.printResult(0, 3);
            return true;
        }

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            char checkNumber = check.charAt(i);
            if (value.charAt(i) == checkNumber) {
                strike++;
                continue;
            }
            if (value.contains(checkNumber + "")) {
                ball++;
            }
        }
        PrintView.printResult(ball, strike);
        return false;
    }

    public static String getRandomValue() {
        StringBuilder sb = new StringBuilder();

        while (sb.length() != 3) {
            String randomNumber = Randoms.pickNumberInRange(1, 9) + "";
            if (!sb.toString().contains(randomNumber)) {
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }

}
