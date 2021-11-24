package baseball.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public static String inputRequest() {

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        Validation.validate(userInput);
        return userInput;
    }

    public static boolean endRequest() {
        // 검증 처리 추가
        System.out.print("숫자를 입력해주세요 : ");
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
