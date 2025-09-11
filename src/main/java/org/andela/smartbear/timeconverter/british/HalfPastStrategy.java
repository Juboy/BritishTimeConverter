package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public class HalfPastStrategy implements TimeExpressionStrategy {

    @Override
    public boolean supports(final int hour, final int minute) {
        return minute == 30;
    }

    @Override
    public String convert(final int hour, final int minute, final NumberToWordsStrategy numberToWordsStrategy) {
        if (hour == 0) {
            return "half past midnight";
        }
        return "half past " + numberToWordsStrategy.convert(hour % 12 == 0 ? 12 : hour % 12).trim();
    }
}
