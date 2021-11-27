package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        Util util = new Util();
        List<Integer> computer = util.initComputer();
        System.out.println(computer);
        while (true) {
            List<Integer> input = util.input();
            String result = game.play(input, computer);
            if (result.equals("1")) {
                computer = util.initComputer();
                System.out.println(computer);
            } else if (result.equals("2")) {
                return;
            } else if (!result.equals("")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
