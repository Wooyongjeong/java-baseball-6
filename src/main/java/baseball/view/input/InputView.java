package baseball.view.input;

import baseball.exception.IllegalBaseballNumbersException;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> inputBaseballNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateNumber(input);
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public int inputGameCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!input.matches("^\\d+$")) {
            throw new IllegalBaseballNumbersException();
        }
    }
}
