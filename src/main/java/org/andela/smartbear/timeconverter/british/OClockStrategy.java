package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public class OClockStrategy implements TimeExpressionStrategy {

    @Override
    public boolean supports(final int hour, final int minute) {
        return minute == 0;
    }

    @Override
    public String convert(final int hour, final int minute, final NumberToWordsStrategy numberToWordsStrategy) {
        if (hour == 0) {
            return "midnight";
        }
        if (hour == 12) {
            return "noon";
        }
        return numberToWordsStrategy.convert(hour % 12 == 0 ? 12 : hour % 12).trim() + " o'clock";
    }
}
