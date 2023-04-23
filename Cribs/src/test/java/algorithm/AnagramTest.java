package algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramTest {

    private final Anagram anagram = new Anagram();

    @ParameterizedTest
    @MethodSource("wordsWithAnswer")
    void checkStrings(String first, String second, boolean expectedResult) {
        final var result = anagram.checkStrings(first, second);

        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> wordsWithAnswer() {
        return Stream.of(
                Arguments.of("one", "noe", true),
                Arguments.of("first", "second", false),
                Arguments.of("", "", true),
                Arguments.of("fffffffff", "fffffffff", true),
                Arguments.of("ff", "f", false),
                Arguments.of("Older and wiser", "I learned words", true)
                        );
    }
}
