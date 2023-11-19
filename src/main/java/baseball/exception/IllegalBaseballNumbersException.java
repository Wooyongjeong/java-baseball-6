package baseball.exception;

public class IllegalBaseballNumbersException extends IllegalArgumentException {
    private static final String MESSAGE = "유효하지 않은 숫자입니다. 다시 입력해 주세요.";

    public IllegalBaseballNumbersException() {
        super(MESSAGE);
    }
}
