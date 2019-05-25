package com.numberword.main;

import com.numberword.exception.NumberWordException;
import com.numberword.constants.NumberWordConstant;
import com.numberword.strategy.ConversionStrategy;

import java.util.logging.Logger;

/**
 * Class to convert numbers to words
 */
public class NumberWord implements ConversionStrategy {
    private static final Logger log = Logger.getLogger(NumberWord.class.getName());

    /**
     * Method for conversion of numbers less than thousand
     *
     * @param number
     * @return
     * @throws NumberWordException
     */
    private String convertLessThanThousand(int number) throws NumberWordException {

        try {

            String currentWord = null;

            if (number % 100 < 20) {
                currentWord = NumberWordConstant.singleUnits[number % 100];
                number /= 100;
            } else {
                currentWord = NumberWordConstant.singleUnits[number % 10];
                number /= 10;

                currentWord = NumberWordConstant.tensUnit[number % 10] + currentWord;
                number /= 10;
            }
            if (number == 0) return currentWord;
            return NumberWordConstant.singleUnits[number] + " hundred and" + currentWord;
        } catch (Exception ex) {
            log.severe("Exception Occurred " + ex);
            throw new NumberWordException("Error in Conversion", ex);

        }
    }

    /**
     * Conversion Method
     *
     * @param number
     * @return Word String
     * @throws NumberWordException
     */
    private String convert(int number) throws NumberWordException {

        if (number == 0) {
            return "zero";
        }

        String word = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String s = convertLessThanThousand(n);
                word = s + NumberWordConstant.biggerUnit[place] + word;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return word.trim();
    }

    /**
     * Implemented Method
     *
     * @param number
     * @return converted number
     */
    @Override
    public String convertNumberToWord(int number) throws NumberWordException {
        return convert(number);
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        NumberWord obj = new NumberWord();
        try {
            System.out.println("==> " + obj.convertNumberToWord(14125));
        } catch (NumberWordException e) {
            log.severe("Exception Occurred: " + e.getMessage());
        }
    }
}
