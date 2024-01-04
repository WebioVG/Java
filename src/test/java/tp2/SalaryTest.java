package tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SalaryTest {
    private Salary salary;

    @BeforeEach
    public void setUp() {
        salary = new Salary();
    }

    @DisplayName("Test paycheck amount calculation without overtime")
    @ParameterizedTest(name = "{0}h worked for {1}€")
    @CsvSource({
            "150, 3000",
            "145.5, 2910",
            "151.67, 3033.4"
    })
    void testCalculatePaycheckAmountWithoutOvertime(
            float hoursNumber,
            float expected
    ) {
        assertEquals(
                expected,
                salary.calculatePaycheckAmount(hoursNumber)
        );
    }

    @DisplayName("Test paycheck amount calculation with overtime")
    @ParameterizedTest(name = "{0}h worked for {1}€")
    @CsvSource({
            "160, 3241.65",
            "165.5, 3379.15",
            "181.67, 3783.4"
    })
    void testCalculatePaycheckAmountWithOvertime(
            float hoursNumber,
            float expected
    ) {
        assertEquals(
                expected,
                salary.calculatePaycheckAmount(hoursNumber)
        );
    }
}