package com.numberword.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.numberword.exception.NumberWordException;
import org.junit.Test;

/**
 * Unit test for NumberWord.
 */
public class NumberWordTest {

    /**
     * Test for Zero
     * @throws NumberWordException
     */
    @Test
    public void convertNumberToWordZeroTest() throws NumberWordException {

        NumberWord numWord = new NumberWord();
        String word = numWord.convertNumberToWord(0);
        assertEquals("zero", word);
    }

    /**
     * Test for Single Numbers
     * @throws NumberWordException
     */
    @Test
    public void convertNumberToWordOneTest() throws NumberWordException {

        NumberWord numWord = new NumberWord();
        String word = numWord.convertNumberToWord(1);
        assertEquals("one", word);
    }

    /**
     * Test for 2 digits
     * @throws NumberWordException
     */
    @Test
    public void convertNumberToWordTwoDigitTest() throws NumberWordException {

        NumberWord numWord = new NumberWord();
        String word = numWord.convertNumberToWord(21);
        assertEquals("twenty one", word);
    }

    /**
     * Test for Hundreds numbers
     * @throws NumberWordException
     */
    @Test
    public void convertNumberToWordHundredTest() throws NumberWordException {

        NumberWord numWord = new NumberWord();
        String word = numWord.convertNumberToWord(105);
        assertEquals("one hundred and five", word);
    }

    /**
     * Test for millions unit
     * @throws NumberWordException
     */
    @Test
    public void convertNumberToWordMillionTest() throws NumberWordException {

        NumberWord numWord = new NumberWord();
        String word = numWord.convertNumberToWord(56945781);
        assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", word);
    }

    /**
     * Test for Exception scenario
     * @throws NumberWordException
     */
    @Test(expected = NumberWordException.class)
    public void convertNumberToWordExceptionTest() throws NumberWordException {

        NumberWord numWord = new NumberWord();
        String word = numWord.convertNumberToWord(-12);

    }
}
