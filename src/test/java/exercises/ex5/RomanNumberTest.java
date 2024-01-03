package exercises.ex5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberTest {
    private RomanNumber romanNumber;

    @BeforeEach
    public void setUp() {
        romanNumber = new RomanNumber();
    }

    @DisplayName("Test de conversion d'un nombre romain correct en nombre arabe")
    @ParameterizedTest(name = "Test {index} : {0} correspond à {1}")
    @CsvSource(
        {
            "IX, 9",
            "X, 10",
            "CC, 200"
        }
    )
    public void testConvertToDecimal(String number, int expected) {
        assertEquals(expected, romanNumber.convertToDecimal(number));
    }

    @DisplayName("Test avec de mauvais chiffres romains")
    @ParameterizedTest(name = "Test {index} : {0} n'est pas un nombre romain correct")
    @ValueSource(strings = {"IXWX", "LMOPQR", "L0XC"})
    public void testWrongCharacters(String number) {
        assertThrows(IllegalArgumentException.class, () -> romanNumber.convertToDecimal(number));
    }

    @DisplayName("Test avec un nombre romain trop long")
    @ParameterizedTest(name = "Test {index} : {0} est trop long")
    @ValueSource(strings = {"IIIIIIIIIIIIIIII", "XIXIXIXIXIXXIXIXIXI", "CMMMMMMCMMMMMMMCMMMMMMC"})
    public void testTooLongNumber(String number) {
        assertThrows(IllegalArgumentException.class, () -> romanNumber.convertToDecimal(number));
    }

    @DisplayName("Test avec un input vide")
    @ParameterizedTest(name = "Test {index} : \"{0}\" sera difficilement convertible")
    @ValueSource(strings = {""})
    public void testEmptyInput(String number) {
        assertThrows(IllegalArgumentException.class, () -> romanNumber.convertToDecimal(number));
    }
}