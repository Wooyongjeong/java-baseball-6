package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {
    @ParameterizedTest
    @CsvSource(value = {
            "456,NOTHING", "312,THREE_BALL_NO_STRIKE", "239,TWO_BALL_NO_STRIKE",
            "127,NO_BALL_TWO_STRIKE", "123,NO_BALL_THREE_STRIKE"})
    void 판정(String input, String expected) {
        //given
        Baseball computer = Baseball.from(List.of(1, 2, 3));
        List<Integer> numbers = input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
        Baseball player = Baseball.from(numbers);

        //when
        Referee referee = Referee.of(computer, player);
        String message = referee.resultMessage();

        //then
        Result expectedResult = Result.valueOf(expected);
        assertThat(message).isEqualTo(expectedResult.getMessage());
    }
}