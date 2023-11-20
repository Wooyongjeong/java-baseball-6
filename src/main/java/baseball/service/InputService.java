package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.GameCommand;
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

    public GameCommand inputGameCommand() {
        int gameCommand = inputView.inputGameCommand();
        return GameCommand.from(gameCommand);
    }
}
