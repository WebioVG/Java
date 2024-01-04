package tp2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Salary {
    private float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Calculates and returns a paycheck amount based on a number of hours worked.
     * @param hoursNumber The number of hours worked.
     * @return The paycheck amount.
     */
    public float calculatePayckeckAmount(float hoursNumber) {
        // Calculate the amount
        float paycheckAmount = hourlyRate * hoursNumber;

        // Set two decimals
        BigDecimal bigDecimal = new BigDecimal(paycheckAmount).setScale(2, RoundingMode.HALF_UP);
        paycheckAmount = bigDecimal.floatValue();

        // Return the amount
        return paycheckAmount;
    }
}
