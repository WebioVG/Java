package exercises.ex5;

import java.util.HashMap;

public class RomanNumber {
    private HashMap<String, Integer> map;

    /**
     * Convert a roman number into a decimal number.
     * @param romanNumber The number to convert.
     * @return The corresponding decimal number.
     */
    public int convertToDecimal(String romanNumber) {
        // Initialize the converting map
        instantiateMap();

        // Check if the provided number is correct
        isRomanNumberCorrect(romanNumber);

        // Variable to store the final result
        int decimalNumber = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            if (i < romanNumber.length() - 1) {
                // Get the current letter and the second one in case it's a combination
                String consecutiveLetters = String.valueOf(romanNumber.charAt(i)) + String.valueOf(romanNumber.charAt(i + 1));

                if (map.containsKey(consecutiveLetters)) {
                    // Add the corresponding value to the final number
                    decimalNumber += map.get(consecutiveLetters);

                    // Skip the next character
                    i++;
                    continue;
                }
            }

            // If the consecutive letters are not found, add the value of the current character
            decimalNumber += map.get(String.valueOf(romanNumber.charAt(i)));
        }

        // Return the result
        return decimalNumber;
    }

    /**
     * Initialize the converting map to associate each roman letter/letter combination with a decimal value
     */
    private void instantiateMap() {
        // HashMap to map letters and letters combinations to their decimal values
        map = new HashMap<String, Integer>()
        {{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};
    }

    /**
     * Check if a roman number has a correct format.
     * @param romanNumber The number to check.
     */
    private void isRomanNumberCorrect(String romanNumber) throws IllegalArgumentException {
        // Ensures the length is not greater than 14
        if (romanNumber.length() > 14) {
            throw new IllegalArgumentException("Le nombre romain est trop long.");
        }

        // Ensures the string is not empty
        if (romanNumber.isEmpty()) {
            throw new IllegalArgumentException("Le nombre romain doit contenir au moins un chiffre romain.");
        }

        // Ensures that all the string characters are roman figures.
        for (int i = 0; i < romanNumber.length(); i++) {
            if (i < romanNumber.length() - 1 && !map.containsKey(String.valueOf(romanNumber.charAt(i)))) {
                throw new IllegalArgumentException("Le nombre romain ne peut contenir que des chiffres romains.");
            }
        }
    }
}
