package baseball.domain;

import baseball.exception.IllegalBaseballNumbersException;
import java.util.List;
import java.util.Set;

public class Baseball {
    private static final int SIZE = 3;
    private final List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalBaseballNumbersException();
        }
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = Set.copyOf(numbers);
        if (set.size() != SIZE) {
            throw new IllegalBaseballNumbersException();
        }
    }
}
