package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    List<Integer> input() {
        String input = Console.readLine();
        validate(input);
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    void validate(String input) {
        if (!validateOneToNine(input)) {
            throw new IllegalArgumentException();
        }
        if (!validateRange(input)) {
            throw new IllegalArgumentException();
        }
        if (!validateDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }

    boolean validateDuplicate(String input) {
        return input.charAt(0) != input.charAt(1)
                && input.charAt(0) != input.charAt(2)
                && input.charAt(1) != input.charAt(2);
    }

    boolean validateRange(String input) {
        return input.length() <= 3 && input.length() >= 1;
    }

    boolean validateOneToNine(String input) {
        String pattern = "^[1-9]*$";
        return Pattern.matches(pattern, input);
    }
}
