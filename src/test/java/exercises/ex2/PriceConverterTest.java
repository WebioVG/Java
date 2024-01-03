package exercises.ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PriceConverterTest {
    private PriceConverter priceConverter;

    @BeforeEach
    public void setUp() {
        // Instantiate the PriceConverter
        priceConverter = new PriceConverter();
    }

    @DisplayName("Test vérifiant le calcul du prix avec TVA")
    @ParameterizedTest(name = "Test {index} : {0} * 1.2 = {1}")
    @CsvSource(
        {
            "8, 9.6",
            "20, 24",
            "51, 61.2"
        }
    )
    public void testAddTaxes(
            float priceWithoutTaxes,
            float expected
    ) {
        assertEquals(expected, priceConverter.addTaxes(priceWithoutTaxes));
    }

    @DisplayName("Teste si un prix est inférieur à zéro")
    @ParameterizedTest(name = "Test {index} : {0} < 0")
    @ValueSource(floats = {-3, -2.3f, -7})
    public void testPriceInferiorToZero(float priceWithoutTaxes) {
        assertThrows(IllegalArgumentException.class, () -> priceConverter.addTaxes(priceWithoutTaxes));
    }
}