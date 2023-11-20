package baseball.domain;

import baseball.exception.IllegalBaseballNumbersException;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Baseball {
    public static final int SIZE = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private final List<Integer> numbers;

    private Baseball(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Baseball from(List<Integer> numbers) {
        return new Baseball(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalBaseballNumbersException();
        }
        Set<Integer> set = Set.copyOf(numbers);
        if (set.size() != SIZE) {
            throw new IllegalBaseballNumbersException();
        }
        if (numbers.contains(0)) {
            throw new IllegalBaseballNumbersException();
        }
    }

    private int getBall(int index) {
        return numbers.get(index);
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countBall(Baseball baseball) {
        return (int) IntStream.range(0, SIZE)
                .filter(i -> {
                    int ball = getBall(i);
                    return baseball.getBall(i) != ball && baseball.contains(ball);
                })
                .count();
    }

    public int countStrike(Baseball baseball) {
        return (int) IntStream.range(0, SIZE)
                .filter(i -> baseball.getBall(i) == getBall(i))
                .count();
    }
}
