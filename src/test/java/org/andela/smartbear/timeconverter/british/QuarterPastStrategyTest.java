package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuarterPastStrategyTest {
    private final NumberToWordsStrategy words = new NumberToEnglishWordsStrategy();
    private final QuarterPastStrategy strategy = new QuarterPastStrategy();


    @ParameterizedTest
    @ValueSource(ints = {40,20,30,14,12,59})
    void shouldNotSupportValueNotQuarterPast(Integer minute) {
        assertFalse(strategy.supports(minute));
    }

    @Test
    void shouldReturnQuarterPastMidnightWhenHourIsZero() {
        assertTrue(strategy.supports(15));
        assertEquals("quarter past midnight", strategy.convert(0, 15, words));
    }

    @Test
    void shouldReturnQuarterPastHour() {
        assertTrue(strategy.supports(15));
        assertEquals("quarter past three", strategy.convert(3, 15, words));
    }
}
