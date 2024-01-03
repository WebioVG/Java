package exercises.ex2;

public class PriceConverter {
    /**
     * Add taxes to a given price (float)
     * @param priceWithoutTaxes The price to convert
     * @return The converted price
     */
    public float addTaxes(float priceWithoutTaxes) {
        // Ensures the price is higher than 0
        checkPriceWithoutTaxes(priceWithoutTaxes);

        // Calculate the new price with taxes
        float priceWithTaxes = calculatePriceWithTaxes(priceWithoutTaxes);

        // Return the new price
        return priceWithTaxes;
    }

    /**
     * Ensures the provided price is a positive number
     * @param priceWithoutTaxes The price to convert
     */
    private void checkPriceWithoutTaxes(float priceWithoutTaxes) {
        if (priceWithoutTaxes < 0) {
            throw new IllegalArgumentException("Le prix à convertir doit être positif.");
        }
    }

    /**
     * Calculates the price with taxes by adding them to the initial price.
     * @param priceWithoutTaxes The price to convert
     * @return The converted price
     */
    private float calculatePriceWithTaxes(float priceWithoutTaxes) {
        // The tax index for the conversion
        float taxIndex = 1.2f;

        // Calculate the price with taxes and return it
        return priceWithoutTaxes * taxIndex;
    }
}
