package baseball.domain;

public class Referee {
    private Result result;

    private Referee(Baseball computer, Baseball player) {
        this.result = compare(computer, player);
    }

    public static Referee of(Baseball computer, Baseball player) {
        return new Referee(computer, player);
    }

    private Result compare(Baseball computer, Baseball player) {
        int ballCount = computer.countBall(player);
        int strikeCount = computer.countStrike(player);
        return Result.of(ballCount, strikeCount);
    }

    public String resultMessage() {
        return result.getMessage();
    }

    public boolean isEnd() {
        return result.isEnd();
    }
}
