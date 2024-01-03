package exercises.ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    private Palindrome palindrome;

    @BeforeEach
    public void setUp() {
        palindrome = new Palindrome();
    }

    @DisplayName("Teste si un nombre est un palindrome")
    @ParameterizedTest(name = "Test {index} : {0} est un palindrome !")
    @ValueSource(ints = {121, 3113, 90809})
    public void testCheckIfPalindrome(int number) {
        assertTrue(palindrome.checkIfPalindrome(number));
    }

    @DisplayName("Test avec un nombre négatif")
    @ParameterizedTest(name = "Test {index} : {0} est négatif.")
    @ValueSource(ints = {-121, -3, -333})
    public void testNegativeNumber(int number) {
        assertThrows(IllegalArgumentException.class, () -> palindrome.checkIfPalindrome(number));
    }

    @DisplayName("Test avec un nombre trop court")
    @ParameterizedTest(name = "Test {index} : {0} ne contient qu'un chiffre.")
    @ValueSource(ints = {1, 3, 9})
    public void testNumberWithOneFigure(int number) {
        assertThrows(IllegalArgumentException.class, () -> palindrome.checkIfPalindrome(number));
    }
}