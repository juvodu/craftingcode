package com.mambu.juvodu.example3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * Test suite for {@link Year}
 *
 * @author jtichomirow
 */
@RunWith(JUnitParamsRunner.class)
public class YearShould {

    @Test
    @Parameters({"5"})
    public void verifyThatNotLeapYearIfNotDivisibleByFour(int number) {

        Year year = new Year(number);

        boolean result = year.isLeap();

        assertFalse(result);
    }

    @Test
    @Parameters({"401"})
    public void verifyThatNotLeapYearIfNotDivisibleByFourHundred(int number) {

        Year year = new Year(number);

        boolean result = year.isLeap();

        assertFalse(result);
    }

    @Test
    @Parameters({"500"})
    public void verifyThatNotLeapYearIfDivisibleByOneHundredButNotByFourHundred(int number) {

        Year year = new Year(number);

        boolean result = year.isLeap();

        assertFalse(result);
    }

    @Test
    @Parameters({"2000"})
    public void verifyThatLeapYearIfDivisibleByOneHundredAndByFourHundred(int number) {

        Year year = new Year(number);

        boolean result = year.isLeap();

        assertTrue(result);
    }
}