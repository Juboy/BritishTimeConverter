package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public class QuarterPastStrategy implements TimeExpressionStrategy {

    @Override
    public boolean supports(final int minute) {
        return minute == 15;
    }

    @Override
    public String convert(final int hour, final int minute, final NumberToWordsStrategy numberToWordsStrategy) {
        if (hour == 0) {
            return "quarter past midnight";
        }
        return "quarter past " + numberToWordsStrategy.convert(hour % 12 == 0 ? 12 : hour % 12).trim();
    }
}
