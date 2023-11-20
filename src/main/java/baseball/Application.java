package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.service.InputService;
import baseball.service.OutputService;
import baseball.view.input.InputView;
import baseball.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        InputService inputService = new InputService(inputView);
        OutputService outputService = new OutputService(outputView);

        BaseballService baseballService = new BaseballService(inputService, outputService);
        BaseballController baseballController = new BaseballController(baseballService);

        baseballController.play();
    }
}
