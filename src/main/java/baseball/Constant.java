package baseball;

public class Constant {
	// String Constant
	public static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요 : ";
	public static final String SUCCESS_AND_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String RESTART_OR_END_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String RESTART_VALUE = "1";
	public static final String END_VALUE = "2";
	public static final String BALL = "볼";
	public static final String STRIKE = "스트라이크";
	public static final String NOTHING = "낫싱";

	// int Constant
	public static final int MAX_BALL_COUNT = 3;
	public static final int MINIMUM_NUMBER = 1;
	public static final int MAXIMUM_NUMBER = 9;
	public static final int ZERO_NUMBER = 0;

	// Exception Constant
	public static final String INVALID_LENGTH = "[ERROR] 세 자리를 입력해야 합니다";
	public static final String INVALID_NUMBER = "[ERROR] 1-9 사이의 숫자 세 개를 입력해야 합니다";
	public static final String OVERLAP_OCCUR = "[ERROR] 중복되는 숫자가 존재합니다";
	public static final String INVALID_END_REQUEST = "[ERROR] 1과 2 중 하나를 입력해야 합니다";
}
