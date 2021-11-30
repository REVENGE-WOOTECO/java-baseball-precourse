package baseball;

import org.junit.jupiter.api.Test;

public class MessagePrintTest {
    MessagePrint messagePrint = new MessagePrint();

    @Test
    public void 메세지_테스트() {
        messagePrint.getResultMessage(1, 1);
    }
}
