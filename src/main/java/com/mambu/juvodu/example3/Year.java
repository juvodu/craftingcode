package com.mambu.juvodu.example3;

/**
 * Year model
 *
 * @author jtichomirow
 */
public class Year {

    private int year;

    public Year(int year) {
        this.year = year;
    }

    /**
     * Checks if the passed year is a leap year
     *
     * @return true if passed year is a leap year
     */
    public boolean isLeap() {

        return divisibleBy(100) ? divisibleBy(400) : divisibleBy(4);
    }

    private boolean divisibleBy(int divisor) {
        return year % divisor == 0;
    }
}
