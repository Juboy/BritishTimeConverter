package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public class MinutesPastStrategy implements TimeExpressionStrategy {

    @Override
    public boolean supports(final int minute) {
        return minute < 30 && minute != 0 && minute != 15;
    }

    @Override
    public String convert(final int hour, final int minute, final NumberToWordsStrategy numberToWordsStrategy) {
        final String minuteString = numberToWordsStrategy.convert(minute).trim();
        final String hourString = (hour == 0 ? "midnight" : numberToWordsStrategy.convert(hour % 12 == 0 ? 12 : hour % 12).trim());
        return minuteString + " past " + hourString;
    }
}
