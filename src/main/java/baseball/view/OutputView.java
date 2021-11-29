package baseball.view;

public class OutputView {

    private static final String GAME_SUCCESS_RESPONSE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public static void printGameResult() {
        System.out.println(GAME_SUCCESS_RESPONSE);
    }
}
