package algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CorrectBracketSequenceTest {

    private final CorrectBracketSequence sequence = new CorrectBracketSequence();

    @ParameterizedTest
    @MethodSource("numberWithAnswer")
    void writeSequence(int n, String[] expectedResult) {
        final var result = sequence.writeSequence(n);

        assertThat(result).containsExactlyInAnyOrder(expectedResult);
    }

    private static Stream<Arguments> numberWithAnswer() {
        return Stream.of(
                Arguments.of(1, new String[] { "()" }),
                Arguments.of(2, new String[] { "()()", "(())" }),
                Arguments.of(3, new String[] { "()()()", "()(())", "(())()", "((()))", "(()())" }),
                Arguments.of(4, new String[] { "()()()()", "(()(()))", "(()())()", "()()(())", "(((())))", "(())()()",
                        "(())(())", "()((()))", "()(())()", "()(()())", "(()()())", "((()()))", "((()))()",
                        "((())())" })
                        );
    }
}
