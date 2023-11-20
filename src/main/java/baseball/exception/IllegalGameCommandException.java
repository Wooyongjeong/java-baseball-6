package baseball.exception;

public class IllegalGameCommandException extends IllegalArgumentException {
    private static final String MESSAGE = "유효하지 않은 커맨드입니다. 다시 입력해 주세요.";

    public IllegalGameCommandException() {
        super(MESSAGE);
    }
}
