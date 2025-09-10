package org.andela.smartbear.numbertoword;

import com.ibm.icu.text.RuleBasedNumberFormat;
import java.util.Locale;
import org.andela.smartbear.numbertoword.exception.InvalidNumberException;

public class NumberToEnglishWordsStrategy implements NumberToWordsStrategy {

    final RuleBasedNumberFormat format;
    static final NumberToEnglishWordsStrategy NUMBER_TO_ENGLISH_WORDS_STRATEGY = new NumberToEnglishWordsStrategy();

    public NumberToEnglishWordsStrategy() {
        this.format = new RuleBasedNumberFormat(Locale.UK, RuleBasedNumberFormat.SPELLOUT);
    }

    /**
     * Convert an Integer to its string equivalent (Must be between 0 and 999 inclusive)
     * @param number Integer value top convert
     * @return String equivalent of the passed Integer
     */
    public String convert(final int number) throws InvalidNumberException {
        final RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(Locale.UK, RuleBasedNumberFormat.SPELLOUT);
        return formatter.format(number).replace("-", " ");
    }

    public static NumberToEnglishWordsStrategy getInstance() {
        return NUMBER_TO_ENGLISH_WORDS_STRATEGY;
    }
}
