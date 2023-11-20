package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.GameCommand;
import baseball.service.BaseballService;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void play() {
        baseballService.gameStart();
        while (true) {
            Baseball computer = baseballService.makeComputer();
            baseballService.playInning(computer);
            GameCommand gameCommand = baseballService.gameCommand();
            if (gameCommand.isEnd()) {
                break;
            }
        }
        baseballService.gameEnd();
    }
}
