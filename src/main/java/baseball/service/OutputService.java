package baseball.service;

import baseball.domain.Referee;
import baseball.view.output.OutputView;

public class OutputService {
    private final OutputView outputView;

    public OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printGameStart() {
        outputView.printGameStart();
    }

    public void printInningResult(Referee referee) {
        outputView.printInningResult(referee.resultMessage());
    }

    public void printInningEnd() {
        outputView.printInningEnd();
    }

    public void printGameEnd() {
        outputView.printGameEnd();
    }

    public void handleException(IllegalArgumentException exception) {
        outputView.printException(exception.getMessage());
    }
}
