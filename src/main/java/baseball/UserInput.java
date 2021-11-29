package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Application.DIGIT;

public class UserInput {
    public String userInput() throws IllegalArgumentException{
        String input;
        input =  Console.readLine();
        return input;
    }
}
