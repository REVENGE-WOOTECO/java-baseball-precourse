package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputRequest() {
        System.out.print("숫자를 입력해주세요 : ");
        // 검증 처리 추가, 같은 숫자로 된 문자열도 경고하기
        return Console.readLine();
    }

    public static boolean reStartRequest() {
        // 검증 처리 추가
        String restartValue = Console.readLine();
        return restartValue.equals("2");
    }
}
