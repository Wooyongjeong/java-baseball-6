package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.exception.IllegalBaseballNumbersException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballTest {
    static Baseball computer;

    @BeforeAll
    static void beforeAll() {
        computer = Baseball.from(List.of(1, 2, 3));
    }

    @ParameterizedTest
    @MethodSource("sizeNotThreeParametersProvider")
    void 세자리_숫자가_아니면_예외_발생(List<Integer> numbers) {
        assertThatThrownBy(() -> Baseball.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(IllegalBaseballNumbersException.class)
                .hasMessageContaining("유효하지 않은 숫자입니다. 다시 입력해 주세요.");
    }

    static Stream<List<Integer>> sizeNotThreeParametersProvider() {
        List<List<Integer>> list = List.of(
                List.of(1, 2, 3, 4),
                List.of(1, 2),
                List.of(1),
                List.of(1, 2, 3, 4, 5)
        );
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("duplicateParametersProvider")
    void 중복된_숫자가_있으면_예외_발생(List<Integer> numbers) {
        assertThatThrownBy(() -> Baseball.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(IllegalBaseballNumbersException.class)
                .hasMessageContaining("유효하지 않은 숫자입니다. 다시 입력해 주세요.");
    }

    static Stream<List<Integer>> duplicateParametersProvider() {
        List<List<Integer>> list = List.of(
                List.of(1, 2, 2),
                List.of(1, 1, 1),
                List.of(3, 3, 3),
                List.of(6, 7, 6),
                List.of(9, 1, 9)
        );
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("withZeroParametersProvider")
    void 숫자에_0이_포함되면_예외_발생(List<Integer> numbers) {
        assertThatThrownBy(() -> Baseball.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(IllegalBaseballNumbersException.class)
                .hasMessageContaining("유효하지 않은 숫자입니다. 다시 입력해 주세요.");
    }

    static Stream<List<Integer>> withZeroParametersProvider() {
        List<List<Integer>> list = List.of(
                List.of(1, 2, 0),
                List.of(6, 0, 5),
                List.of(0, 4, 9)
        );
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("successParametersProvider")
    void 정상_생성(List<Integer> numbers) {
        assertDoesNotThrow(() -> Baseball.from(numbers));
    }

    static Stream<List<Integer>> successParametersProvider() {
        List<List<Integer>> list = List.of(
                List.of(1, 2, 3),
                List.of(5, 6, 7),
                List.of(9, 4, 6),
                List.of(8, 3, 1)
        );
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("countBallParametersProvider")
    void 볼_개수(List<Integer> numbers, int expected) {
        //given
        Baseball player = Baseball.from(numbers);

        //when
        int ballCount = computer.countBall(player);

        //then
        assertThat(ballCount).isEqualTo(expected);
    }

    static Stream<Arguments> countBallParametersProvider() {
        return Stream.of(
                Arguments.of(List.of(5, 6, 7), 0),
                Arguments.of(List.of(2, 3, 4), 2),
                Arguments.of(List.of(3, 4, 5), 1),
                Arguments.of(List.of(3, 1, 2), 3),
                Arguments.of(List.of(1, 2, 3), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("countStrikeParametersProvider")
    void 스트라이크_개수(List<Integer> numbers, int expected) {
        //given
        Baseball player = Baseball.from(numbers);

        //when
        int strikeCount = computer.countStrike(player);

        //then
        assertThat(strikeCount).isEqualTo(expected);
    }

    static Stream<Arguments> countStrikeParametersProvider() {
        return Stream.of(
                Arguments.of(List.of(5, 6, 7), 0),
                Arguments.of(List.of(2, 3, 4), 0),
                Arguments.of(List.of(3, 4, 5), 0),
                Arguments.of(List.of(3, 1, 2), 0),
                Arguments.of(List.of(1, 2, 4), 2),
                Arguments.of(List.of(1, 8, 9), 1),
                Arguments.of(List.of(1, 2, 3), 3)
        );
    }
}