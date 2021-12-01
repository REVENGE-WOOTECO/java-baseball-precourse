package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Util util = new Util();
        Game game = new Game(util);
        List<Integer> computer = util.initComputer();
        while (true) {
            List<Integer> input = util.input();
            String result = game.play(input, computer);
            if (result.equals("1")) {
                computer = util.initComputer();
            } else if (result.equals("2")) {
                return;
            } else if (!result.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
