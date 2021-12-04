package VO;

public class ReplyNumber {
    public static final String RESTART = "1";
    public static final String EXIT = "2";
    private final String value;

    public ReplyNumber(String value) {
        if (!validateContinueNumber(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public boolean validateContinueNumber(String input) {
        return input.equals(RESTART) || input.equals(EXIT);
    }

    public String value() {
        return value;
    }

    public boolean isRestart() {
        return value.equals(RESTART);
    }

    public boolean isExit() {
        return value.equals(EXIT);
    }
}
