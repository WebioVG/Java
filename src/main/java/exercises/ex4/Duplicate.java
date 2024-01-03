package exercises.ex4;

public class Duplicate {
    /**
     * Check if an array of integers contains a duplicate.
     * @param array The array to check.
     * @return True or false.
     */
    public boolean containsDuplicate(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
