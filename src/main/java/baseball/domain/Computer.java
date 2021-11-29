package baseball.domain;

public class Computer {

    private final Number number;

    private Computer(Number number) {
        this.number = number;
    }

    public static Computer create() {
        Number numbers = Number.createRandomNumber();
        return new Computer(numbers);
    }

    public Number getNumber() {
        return number;
    }
}
