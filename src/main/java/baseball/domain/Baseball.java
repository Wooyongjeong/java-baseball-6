package baseball.domain;

import java.util.List;

public class Baseball {
    private final List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

    }
}
