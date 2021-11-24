package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private String value;

    private Computer(String value) {
        this.value = value;
    }

    public static Computer setValue() {
        return new Computer(getRandomValue());
    }

    public boolean checkValue(String check) {

        return false;
    }

    public static String getRandomValue() {
        StringBuilder sb = new StringBuilder();

        while (sb.length() != 3) {
            String randomNumber = Randoms.pickNumberInRange(1, 9) + "";
            if(!sb.toString().contains(randomNumber)) {
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }

}
