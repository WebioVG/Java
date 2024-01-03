package exercises.ex1;

import java.util.ArrayList;

public class Mean {
    private ArrayList<Integer> marks;
    private int mean;

    /**
     * Takes a list of marks and returns the mean.
     * @param marks The list of marks.
     * @return The mean.
     */
    public int getMean(ArrayList<Integer> marks) {
        // Check if the marks are in a correct format
        checkMarks(marks);

        // Check that the user entered 3 marks
        checkMarksNumber(marks);

        // Calculate and return the mean
        return calculateMean(marks);
    }

    /**
     * Throws an exception if at least one mark is lower than 0 or higher than 20.
     * @param marks The list of marks.
     * @throws IllegalArgumentException The exception.
     */
    private void checkMarks(ArrayList<Integer> marks) throws IllegalArgumentException {
        for (Integer mark : marks) {
            if (mark < 0 || mark > 20) {
                throw new IllegalArgumentException("A mark should range from 0 to 20.");
            }
        }
    }

    /**
     * Ensures that the list of marks contains precisely 3 marks.
     * @param marks The list of marks.
     * @throws IllegalArgumentException The exception.
     */
    private void checkMarksNumber(ArrayList<Integer> marks) throws IllegalArgumentException {
        if (marks.size() != 3) {
            throw new IllegalArgumentException("There should be three marks.");
        }
    }

    /**
     * Calculates and returns the mean of the marks.
     * @param marks The list of marks.
     * @return The mean.
     */
    private int calculateMean(ArrayList<Integer> marks) {
        int sum = 0;

        for (Integer mark : marks) {
            sum += mark;
        }

        return sum / marks.size();
    }
}
