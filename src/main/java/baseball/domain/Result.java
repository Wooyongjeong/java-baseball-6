package baseball.domain;

import baseball.exception.IllegalBaseballNumbersException;
import java.util.Arrays;

public enum Result {
    NOTHING("낫싱", 0, 0),
    ONE_BALL_NO_STRIKE("1볼", 1, 0),
    TWO_BALL_NO_STRIKE("2볼", 2, 0),
    THREE_BALL_NO_STRIKE("3볼", 3, 0),
    NO_BALL_ONE_STRIKE("1스트라이크", 0, 1),
    NO_BALL_TWO_STRIKE("2스트라이크", 0, 2),
    NO_BALL_THREE_STRIKE("3스트라이크", 0, 3),
    ONE_BALL_ONE_STRIKE("1볼 1스트라이크", 1, 1),
    TWO_BALL_ONE_STRIKE("2볼 1스트라이크", 2, 1),
    ONE_BALL_TWO_STRIKE("1볼 2스트라이크", 1, 2),
    ;

    private final String message;
    private final int ballCount;
    private final int strikeCount;

    Result(String message, int ballCount, int strikeCount) {
        this.message = message;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static Result of(int ballCount, int strikeCount) {
        return Arrays.stream(Result.values())
                .filter(result -> result.ballCount == ballCount)
                .filter(result -> result.strikeCount == strikeCount)
                .findAny()
                .orElseThrow(IllegalBaseballNumbersException::new);
    }

    public String getMessage() {
        return message;
    }

    public boolean isEnd() {
        return this == NO_BALL_THREE_STRIKE;
    }
}
