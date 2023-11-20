package baseball.service;

import baseball.domain.Baseball;
import baseball.view.input.InputView;
import java.util.List;

public class InputService {
    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public Baseball inputBaseballNumbers() {
        List<Integer> numbers = inputView.inputBaseballNumbers();
        return Baseball.from(numbers);
    }
}
