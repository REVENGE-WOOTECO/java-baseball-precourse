package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {

    private static final int BASE_COUNT = 3;
    private static final String PATTERN_REGEX = "^[1-9]*$";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_REGEX);
    private static final String DELIMITER = "";

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
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(String input) {
        validateOneToNine(input);
        validateRange(input);
        validateDuplicate(input);
    }

    private void validateDuplicate(String input) {
        Set<Character> validSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            validSet.add(input.charAt(i));
        }
        if (validSet.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String input) {
        if (BASE_COUNT != input.length()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOneToNine(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public int getBaseCount() {
        return BASE_COUNT;
    }
}
