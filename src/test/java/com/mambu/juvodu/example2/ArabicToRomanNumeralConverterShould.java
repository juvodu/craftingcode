package com.mambu.juvodu.example2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * Test suite for {@link ArabicToRomanNumeralConverter}
 *
 * @author jtichomirow
 */
@RunWith(JUnitParamsRunner.class)
public class ArabicToRomanNumeralConverterShould {

    @Test
    @Parameters({
            "1, I",
            "3, III",
            "4, IV",
            "5, V",
            "10, X",
            "19, XIX",
            "50, L",
            "100, C",
            "500, D",
            "1000, M",
            "3000, MMM",
            "3499, MMMCDXCIX"})
    public void returnRomanNumeralWhenConvertArabicNumber(int number, String roman) {

        ArabicToRomanNumeralConverter arabicToRomanNumeralConverter = new ArabicToRomanNumeralConverter(number);

        String result = arabicToRomanNumeralConverter.convert();

        assertEquals(roman, result);
    }
}