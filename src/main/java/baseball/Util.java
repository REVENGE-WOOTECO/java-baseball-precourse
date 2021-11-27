package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static final int BASE_COUNT = 3;

    List<Integer> initComputer() {
        List<Integer> computer = new ArrayList<>(BASE_COUNT);
        while (computer.size() < BASE_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
