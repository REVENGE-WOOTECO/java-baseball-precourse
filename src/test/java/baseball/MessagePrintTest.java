package baseball;

import VO.ResultNumbers;
import org.junit.jupiter.api.Test;

public class MessagePrintTest {
    MessagePrint messagePrint = new MessagePrint();

    @Test
    public void 메세지_테스트() {
        ResultNumbers result = new ResultNumbers(1, 1);
        messagePrint.getResultMessage(result);
    }
}
