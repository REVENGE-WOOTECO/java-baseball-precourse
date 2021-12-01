package baseball;

import java.util.List;

public class Application {

    private static final String CONTINUE = "1";
    private static final String EXIT = "2";

    public static void main(String[] args) {
        Util util = new Util();
        Game game = new Game(util);
        List<Integer> computer = util.initComputer();
        while (true) {
            List<Integer> input = util.input();
            String result = game.play(input, computer);
            if (result.equals(CONTINUE)) {
                computer = util.initComputer();
            } else if (result.equals(EXIT)) {
                return;
            } else if (!result.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
