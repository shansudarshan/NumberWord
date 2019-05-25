package com.numberword.strategy;

import com.numberword.exception.NumberWordException;

public interface ConversionStrategy {

    public String convertNumberToWord(int number) throws NumberWordException;
}
