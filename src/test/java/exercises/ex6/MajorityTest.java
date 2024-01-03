package exercises.ex6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MajorityTest {
    private Majority majority;

    @BeforeEach
    public void setUp() {
        majority = new Majority();
    }

    @DisplayName("Test pour trouver l'élément majoritaire d'un tableau d'integers")
    @ParameterizedTest(name = "Test {index} : {1} est majoritaire dans {0}")
    @MethodSource("argumentsGetMajorityElement")
    public void testGetMajorityElement(int[] array, int expected) {
        assertEquals(expected, majority.getMajorityElement(array));
    }

    private static Stream<Arguments> argumentsGetMajorityElement() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 2, 2, 3}, 2),
                Arguments.of((Object) new int[]{2, 3, 3, 4, 7, 7, 7, 7, 7}, 7)
        );
    }

    @DisplayName("Test avec un tableau à plus de 50000 éléments")
    @Test
    public void testGetMajorityElementEmptyArray() {
        // Size of the new array which will be generated as input
        int arraySize = 50100;

        // Initialize the array
        int[] array = new int[arraySize];

        // Populate the array
        for (int i = 1; i < 50100; i++) {
            array[i] = i;
        }

        assertThrows(IllegalArgumentException.class, () -> majority.getMajorityElement(array));
    }

    @DisplayName("Test avec des nombres trop petits ou grands")
    @ParameterizedTest
    @MethodSource("argumentsGetMajorityElementWrongNumbers")
    public void testGetMajorityElementWrongNumbers(int[] array) {
        assertThrows(
                IllegalArgumentException.class,
                () -> majority.getMajorityElement(array)
        );
    }

    private static Stream<Arguments> argumentsGetMajorityElementWrongNumbers() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 2, 2345678, 3}),
                Arguments.of((Object) new int[]{2, 666666666, 968})
        );
    }
}