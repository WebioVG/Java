package exercises.ex6;

public class Majority {
    /**
     * Get the majority element in an array.
     * @param array The array.
     * @return The majority element.
     */
    public int getMajorityElement(int[] array) {
        // Ensures the input respects the constraints
        checkArray(array);

        int element = 0;
        int counter = 0;

        for (int i : array) {
            if (counter == 0) {
                element = i;
                counter = 1;
            } else if (element == i) {
                counter++;
            } else {
                counter--;
            }
        }

        return element;
    }

    /**
     * Check if the array is correct.
     * @param array The array.
     * @throws IllegalArgumentException The exception.
     */
    private void checkArray(int[] array) throws IllegalArgumentException {
        if (array.length < 1 || array.length > 50000) {
            throw new IllegalArgumentException("Le tableau doit contenir entre 1 et 50000 éléments.");
        }

        for (int i : array) {
            if (i < Math.pow(-10, 9) || i > (5 * Math.pow(10, 4))) {
                throw new IllegalArgumentException("Tous les nombres doivent être compris entre -10^9 et 5*10^4");
            }
        }
    }
}
