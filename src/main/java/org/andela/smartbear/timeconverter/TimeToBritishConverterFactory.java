package org.andela.smartbear.timeconverter;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.andela.smartbear.timeconverter.british.BritishTimeConverterStrategy;

public class TimeToBritishConverterFactory implements TimeToWordsFactory {

    @Override
    public NumberToWordsStrategy createNumberToWords() {
        return NumberToEnglishWordsStrategy.getInstance();
    }

    @Override
    public TimeConverterStrategy createTimeConverter() {
        return new BritishTimeConverterStrategy(createNumberToWords());
    }
}
