package fr.m2i.demo.calculator;

public class Calculator {
    /**
     * Add two numbers together and return the result.
     * @param a The first number
     * @param b The second number
     * @return The sum.
     */
    public float add(float a, float b) {
        return a + b;
    }

    public float substract(float a, float b) {
        return a - b;
    }

    public float multiply(float a, float b) {
        return a * b;
    }

    public float divide(float a, float b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("La division par zéro est impossible.");
        }

        return a / b;
    }
}