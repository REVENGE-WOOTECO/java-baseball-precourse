package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NUMBER_REQUEST = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_NUMBER_REQUEST = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String requestInputNumber() {
        System.out.println(INPUT_NUMBER_REQUEST);
        return Console.readLine();
    }

    public static String requestRestartInputNumber() {
        System.out.println(RESTART_INPUT_NUMBER_REQUEST);
        return Console.readLine();
    }
}
