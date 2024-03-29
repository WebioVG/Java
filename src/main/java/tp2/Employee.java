package tp2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Employee {
    private Salary salary;
    private Identity identity;

    public Salary getSalary() {
        return salary;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    /**
     * Allows an employee to move to a new house. Changes its postal address.
     * @param address The new address.
     */
    public void move(Address address) {
        identity.setAddress(address);
    }

    /**
     * Makes the employee work for a certain number of hours which allows him to earn money.
     * @param hoursNumber The number of hours worked.
     * @return A string indicating what has been done.
     */
    public String work(float hoursNumber) {
        float paycheckAmount = salary.calculatePaycheckAmount(hoursNumber);

        return
            "The employee worked for " +
            hoursNumber +
            " hours and earned " +
            paycheckAmount +
            " euros."
        ;
    }

    /**
     * Makes the employee work for 151.67 hours which allows him to earn money.
     * @return A string indicating what has been done.
     */
    public String work() {
        return work(151.67f);
    }

    /**
     * Increase by the given percentage the hourly rate of the employee.
     * @param percentage The percentage to increase the salary with.
     */
    public void giveARaise(int percentage) {
        // Calculate the new hourly rate
        float newHourlyRate = salary.getHourlyRate() * (1 + (float) percentage / 100);

        // Set two decimals
        BigDecimal bigDecimal = new BigDecimal(newHourlyRate).setScale(2, RoundingMode.HALF_UP);
        newHourlyRate = bigDecimal.floatValue();

        // Set the new hourly rate
        salary.setHourlyRate(newHourlyRate);
    }
}
