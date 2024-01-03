package exercises.ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MeanTest {
    private Mean meanInstance;

    @BeforeEach
    public void setUp() {
        meanInstance = new Mean();
    }

    @DisplayName("Test de calcul de moyenne")
    @ParameterizedTest(name = "Test {index} : ({0} + {1} + {2}) / 3 = {4}")
    @CsvSource({
        "0, 10, 20, 10",
        "10, 10, 10, 10",
        "10, 15, 20, 15"
    })
    public void testGetMean(
            int firstMark,
            int secondMark,
            int thirdMark,
            int expected
    ) {
        ArrayList<Integer> marks = new ArrayList<Integer>() {
            {
                add(firstMark);
                add(secondMark);
                add(thirdMark);
            }
        };

        int result = meanInstance.getMean(marks);

        assertEquals(expected, result);
    }

    @DisplayName("Test pas assez de notes")
    @ParameterizedTest()
    @CsvSource({
            "0, 10, 5"
    })
    public void testGetMeanTooFewMarks(int firstMark, int secondMark) {
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(firstMark);
        marks.add(secondMark);

        assertThrows(IllegalArgumentException.class, () -> meanInstance.getMean(marks));
    }

    @DisplayName("Test trop de notes")
    @ParameterizedTest()
    @CsvSource({
            "0, 10, 10, 20, 10"
    })
    public void testGetMeanTooManyMarks(
            int firstMark,
            int secondMark,
            int thirdMark,
            int fourthMark
    ) {
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(firstMark);
        marks.add(secondMark);
        marks.add(thirdMark);
        marks.add(fourthMark);

        assertThrows(IllegalArgumentException.class, () -> meanInstance.getMean(marks));
    }

    @DisplayName("Note inférieure à zéro")
    @ParameterizedTest()
    @CsvSource({
            "0, 10, -20, 10",
            "10, -3, 10, 10",
            "-10, 15, 20, 15"
    })
    public void testGetMeanMarkInferiorToZero(
            int firstMark,
            int secondMark,
            int thirdMark
    ) {
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(firstMark);
        marks.add(secondMark);
        marks.add(thirdMark);

        assertThrows(IllegalArgumentException.class, () -> meanInstance.getMean(marks));
    }
}