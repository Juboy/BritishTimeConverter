package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToWordsStrategy;

public interface TimeExpressionStrategy {

    boolean supports(int hour, int minute);

    String convert(int hour, int minute, NumberToWordsStrategy numberToWordsStrategy);
}
