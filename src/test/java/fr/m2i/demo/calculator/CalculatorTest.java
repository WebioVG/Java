package fr.m2i.demo.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    private float premierNombre;
    private float secondNombre;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        premierNombre = 0;
        secondNombre = 0;
    }

    @Test
    @DisplayName("Test des additions")
    public void add() {
        // Arrange
        premierNombre = 3.2f;
        secondNombre = 1.8f;

        // Act
        float result = this.calculator.add(premierNombre, secondNombre);

        // Assert
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test des soustractions")
    public void substract() {
        // Arrange
        premierNombre = 3;
        secondNombre = 1.5f;

        // Act
        float result = this.calculator.substract(premierNombre, secondNombre);

        // Assert
        assertEquals(1.5f, result);
    }

    @Test
    @DisplayName("Test des multiplications")
    public void multiply() {
        // Arrange
        premierNombre = 3;
        secondNombre = 5;

        // Act
        float result = this.calculator.multiply(premierNombre, secondNombre);

        // Assert
        assertEquals(15, result);
    }

    @Test
    @DisplayName("Test des divisions")
    public void divide() {
        // Arrange
        premierNombre = 6;
        secondNombre = 2;

        // Act
        float result = this.calculator.divide(6, 2);

        // Assert
        assertEquals(3, result);
    }

    @ParameterizedTest(name = "Test {index} : {0} + {1} = {2}")
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "100, 1000, 1100"
    })
    @DisplayName("Test paramétré")
    public void parameterizedAdd(
            float premierNombre,
            float secondNombre,
            float expected
    ) {
        float result = this.calculator.add(premierNombre, secondNombre);

        assertEquals(expected, result);
    }

    @DisplayName("Division par zéro")
    @ParameterizedTest(name = "Test {index} : {0} / 0")
    @ValueSource(floats = {1, 50, 100, 1000})
    public void testDivisionParZero(final float premierNombre) {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(premierNombre, 0));
    }
}