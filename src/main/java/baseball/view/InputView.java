package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputRequest() {

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            if (validate(userInput)) {
                return userInput;
            }
            System.out.print("올바르지 않은 입력입니다. 다시 ");
        }
    }

    // 따로 검증 로직 클래스로 분리하기
    private static boolean validate(String userInput) {

        // 길이 검증
        if (userInput.length() != 3) {
            return false;
        }

        // 숫자 여부 검증
        if (!validateNumberFormat(userInput)) {
            return false;
        }

        // 중복되는 수 여부 검증
        if (!validateOverlap(userInput)) {
            return false;
        }

        return true;
    }

    private static boolean validateNumberFormat(String userInput) {
        return userInput.replaceAll("[1-9]", "").equals("");
    }

    private static boolean validateOverlap(String userInput) {
        boolean[] overlapChk = new boolean[3];
        for (int j = 0; j < 3; j++) {
            overlapChk[j] = true;

            for (int k = 0; k < 3; k++) {
                if (overlapChk[k]) continue;
                if (userInput.charAt(j) == userInput.charAt(k)) {
                    return false;
                }
            }
            overlapChk[j] = false;
        }
        return true;
    }

    public static boolean endRequest() {
        // 검증 처리 추가
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String restartValue = Console.readLine();

            if (restartValue.equals("1")) {
                return false;
            }

            if (restartValue.equals("2")) {
                return true;
            }

            System.out.print("올바르지 않은 입력입니다. 다시 ");
        }
    }
}
