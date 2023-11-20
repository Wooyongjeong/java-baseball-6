package baseball.view.output;

public class OutputView {
    private static final String ERROR = "[ERROR] ";

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInningResult(String result) {
        System.out.println(result);
    }

    public void printInningEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameEnd() {
        System.out.println("숫자 야구 게임을 종료합니다.");
    }

    public void printException(String message) {
        System.out.println(ERROR + message);
    }
}
