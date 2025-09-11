package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public class QuarterToStrategy implements TimeExpressionStrategy {

    @Override
    public boolean supports(final int hour, final int minute) {
        return minute == 45;
    }

    @Override
    public String convert(final int hour, final int minute, final NumberToWordsStrategy numberToWordsStrategy) {
        final int toHour = (hour + 1) % 12 == 0 ? 12 : (hour + 1) % 12;
        return "quarter to " + numberToWordsStrategy.convert(toHour).trim();
    }
}
