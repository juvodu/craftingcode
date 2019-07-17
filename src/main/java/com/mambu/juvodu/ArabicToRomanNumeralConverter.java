package com.mambu.juvodu;

/**
 * Converter from arabic to roman numerals
 *
 * @author jtichomirow
 */
public class ArabicToRomanNumeralConverter {

    private int number;

    ArabicToRomanNumeralConverter(int number) {
        this.number = number;
    }

    String convert() {

        String result = "";

        for (RomanNumeral romanNumeral : RomanNumeral.values()) {
            result = decreaseNumberAndAddNumeral(romanNumeral, result);
        }

        return result;
    }

    private String decreaseNumberAndAddNumeral(RomanNumeral romanNumeral, String result) {

        while (number >= romanNumeral.arabic) {
            number -= romanNumeral.arabic;
            result += romanNumeral.roman;
        }

        return result;
    }

    enum RomanNumeral {

        M(1000, "M"),
        D(500, "D"),
        XD(400, "CD"),
        C(100, "C"),
        XC(90, "XC"),
        L(50, "L"),
        XL(40, "XL"),
        X(10, "X"),
        IX(9, "IX"),
        V(5, "V"),
        IV(4, "IV"),
        I(1, "I");

        int arabic;
        String roman;

        RomanNumeral(int arabic, String roman) {

            this.arabic = arabic;
            this.roman = roman;
        }
    }
}
