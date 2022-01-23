package baseball;

//모든 메서드마다 검증을 해야하는 중복으로 인해 비즈니스 로직을 하나로 묶어
//class로 만든다.
public class Ball {

	private static final int MINIMUN_NUMBER = 1;

	// 값이 불변하도록
	private final int number;

	// 주생성자, 부생성자 패턴
	//주생성자
	public Ball(int number) {
		numberValidate(number);
		this.number = number;
	}

	//부생성자
	public Ball(String number) {
		this(convertInteger(number));
	}

	private static int convertInteger(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			// 에러 되던지기
			throw new RuntimeException("입력된 number가 정수값이 아닙니다.", e);
		}
	}

	private void numberValidate(int number) {
		if (number < MINIMUN_NUMBER) {
			throw new RuntimeException(
				String.format("number가 최소 숫자보다 작습니다. 입력된 숫자 : %d, 최소 숫자 : %d", number,
					MINIMUN_NUMBER));
		}
	}

	public int getNumber(){
		return number;
	}
}
