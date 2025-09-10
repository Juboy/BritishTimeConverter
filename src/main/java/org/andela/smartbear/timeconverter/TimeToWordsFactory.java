package org.andela.smartbear.timeconverter;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public interface TimeToWordsFactory {
    NumberToWordsStrategy createNumberToWords();

    TimeConverterStrategy createTimeConverter();
}
