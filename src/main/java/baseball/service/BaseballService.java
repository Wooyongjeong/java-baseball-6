package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.GameCommand;
import baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballService {
    private final InputService inputService;
    private final OutputService outputService;

    public BaseballService(InputService inputService, OutputService outputService) {
        this.inputService = inputService;
        this.outputService = outputService;
    }

    public void gameStart() {
        outputService.printGameStart();
    }

    public Baseball makeComputer() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Baseball.SIZE) {
            int number = Randoms.pickNumberInRange(Baseball.MIN_NUM, Baseball.MAX_NUM);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return Baseball.from(numbers);
    }

    private Baseball makePlayer() {
        return inputService.inputBaseballNumbers();
    }

    public void playInning(Baseball computer) {
        while (true) {
            Baseball player = makePlayer();
            Referee referee = Referee.of(computer, player);
            outputService.printInningResult(referee);
            if (referee.isEnd()) {
                break;
            }
        }
        outputService.printInningEnd();
    }

    public GameCommand gameCommand() {
        return inputService.inputGameCommand();
    }

    public void gameEnd() {
        outputService.printGameEnd();
    }
}
