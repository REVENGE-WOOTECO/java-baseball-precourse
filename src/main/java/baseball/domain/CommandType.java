package baseball.domain;

import baseball.ErrorMessage;
import java.util.Arrays;

public enum CommandType {

    RESTART("1"), END("2");

    private final String code;

    CommandType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static CommandType of(String command) {
        return Arrays.stream(CommandType.values())
            .filter(v -> v.getCode().equals(command))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT_REQUEST));
    }
}
