package tp2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Salary {
    private float hourlyRate = 20;

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
    public float calculatePaycheckAmount(float hoursNumber) {
        if (hoursNumber <= 151.67f) {
            return calculatePaycheckAmountWithoutOvertime(hoursNumber);
        }

        return calculatePaycheckAmountWithOvertime(hoursNumber);
    }

    private float calculatePaycheckAmountWithoutOvertime(float hoursNumber) {
        // Calculate the amount
        float paycheckAmount = hourlyRate * hoursNumber;

        // Set two decimals
        BigDecimal bigDecimal = new BigDecimal(paycheckAmount).setScale(2, RoundingMode.HALF_UP);
        paycheckAmount = bigDecimal.floatValue();

        // Return the amount
        return paycheckAmount;
    }

    private float calculatePaycheckAmountWithOvertime(float hoursNumber) {
        // Calculate the part of the paycheck amount without overtime
        float paycheckAmountWithoutOvertime = hourlyRate * 151.67f;

        // Calculate the part of the paycheck amount with overtime
        float overtimeHours = hoursNumber - 151.67f;
        float paycheckAmountWithOvertime = overtimeHours * hourlyRate * 1.25f;

        // Calculate the total paycheck amount
        float totalPaycheck = paycheckAmountWithoutOvertime + paycheckAmountWithOvertime;

        // Set two decimals
        BigDecimal bigDecimal = new BigDecimal(totalPaycheck).setScale(2, RoundingMode.HALF_UP);
        totalPaycheck = bigDecimal.floatValue();

        // Return the amount
        return totalPaycheck;
    }
}
