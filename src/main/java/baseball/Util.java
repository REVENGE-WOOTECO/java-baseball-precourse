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

    public List<Integer> initComputer() {
        List<Integer> computer = new ArrayList<>(BASE_COUNT);
        while (computer.size() < BASE_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> input() {
        String input = Console.readLine();
        validate(input);
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validate(String input) {
        validateOneToNine(input);
        validateRange(input);
        validateDuplicate(input);
    }

    private void validateDuplicate(String input) throws IllegalArgumentException {
        if (input.charAt(0) != input.charAt(1)
                && input.charAt(0) != input.charAt(2)
                && input.charAt(1) != input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String input) {
        if (input.length() != BASE_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOneToNine(String input) {
        String pattern = "^[1-9]*$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException();
        }
    }
}
