package baseball.domain;

import baseball.exception.IllegalGameCommandException;
import java.util.Arrays;

public enum GameCommand {
    CONTINUE(1),
    END(2),
    ;

    private final int command;

    GameCommand(int command) {
        this.command = command;
    }

    public static GameCommand from(int command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command == command)
                .findAny()
                .orElseThrow(IllegalGameCommandException::new);
    }

    public boolean isEnd() {
        return this == END;
    }
}
