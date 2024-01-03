package exercises.ex3;

public class Palindrome {
    /**
     * Check if a number has the potential to be a palindrome and check if it is.
     * @param number The number to check.
     * @return True or false.
     */
   public boolean checkIfPalindrome(int number) {
        // Ensures the number is greater than 0 and contains at least two figures
        checkNumber(number);

        // Check if the number is a palindrome
        boolean result = isPalindrome(number);

        // Return the result
        return result;
   }

   /**
     * Check if a number is greater than zero and if it contains at least two figures.
     * @param number The number to check.
     * @throws IllegalArgumentException The exception.
     */
   private void checkNumber(int number) throws IllegalArgumentException {
       // Is the number less than zero?
       if (number < 0) {
           throw new IllegalArgumentException("Le nombre doit être supérieur à 0.");
       }

       // Does the number contain less than two figures?
       if (number < 10) {
           throw new IllegalArgumentException("Le nombre doit contenir au moins deux chiffres.");
       }
   }

    /**
     * Check if a number is a palindrome.
     * @param number The number to check.
     * @return True or false.
     */
   private boolean isPalindrome(int number) {
       // Store the number to test and initialize its reversed version
       int numberToTest = number;
       int reversed = 0;

       // Iterate while the number to test is greater than 0
       while (numberToTest > 0) {
           // Get the last number figure
           int rest = numberToTest % 10;

           // Add it to the end of the reversed number
           reversed = reversed * 10 + rest;

           // Remove the last figure of the number to test
           numberToTest /= 10;
       }

       // Return true whenever both the initial and reversed numbers are identical
       return number == reversed;
   }
}
