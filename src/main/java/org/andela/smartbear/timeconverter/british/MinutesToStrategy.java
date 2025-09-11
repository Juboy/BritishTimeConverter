package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public class MinutesToStrategy implements  TimeExpressionStrategy {

    @Override
    public boolean supports(final int minute) {
        return minute > 30 && minute != 45 && minute < 60;
    }

    @Override
    public String convert(final int hour, final int minute, final NumberToWordsStrategy numberToWordsStrategy) {
        final int minuteOffset = 60 - minute;
        final String minuteOffsetString = numberToWordsStrategy.convert(minuteOffset).trim();
        final int toHour = (hour + 1) % 12 == 0 ? 12 : (hour + 1) % 12;
        return minuteOffsetString + " to " + numberToWordsStrategy.convert(toHour).trim();
    }
}
