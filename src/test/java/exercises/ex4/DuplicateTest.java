package exercises.ex4;

import exercises.ex3.Palindrome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateTest {
    private Duplicate duplicate;

    @BeforeEach
    public void setUp() {
        duplicate = new Duplicate();
    }

    @DisplayName("Test vérification de doublons avec doublon")
    @ParameterizedTest(name = "Test {index}")
    @MethodSource("argumentsContainsDuplicateTrue")
    public void testContainsDuplicateTrue(int[] array) {
        assertTrue(duplicate.containsDuplicate(array));
    }

    @DisplayName("Test vérification de doublons sans doublon")
    @ParameterizedTest(name = "Test {index}")
    @MethodSource("argumentsContainsDuplicateFalse")
    public void testContainsDuplicateFalse(int[] array) {
        assertFalse(duplicate.containsDuplicate(array));
    }

    private static Stream<Arguments> argumentsContainsDuplicateTrue() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 3, 4, 3, 6}),
                Arguments.of((Object) new int[]{2, 3, 4, 4, 7, 8})
        );
    }

    private static Stream<Arguments> argumentsContainsDuplicateFalse() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 3, 4, 6, 18}),
                Arguments.of((Object) new int[]{2, 3, 4, 7, 8, 43})
        );
    }
}