package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.INPUT_NUMBER;


public class InputView {

    public static String inputRequest() {

        System.out.print(INPUT_NUMBER);
        String userInput = Console.readLine();
        Validation.validate(userInput);
        return userInput;
    }

    public static boolean endRequest() {
        String restartValue = Console.readLine();

        if (restartValue.equals("1")) {
            return false;
        }

        if (restartValue.equals("2")) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
