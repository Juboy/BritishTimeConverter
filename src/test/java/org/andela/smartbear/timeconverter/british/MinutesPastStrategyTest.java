package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinutesPastStrategyTest {

    private final NumberToWordsStrategy words = new NumberToEnglishWordsStrategy();
    private final MinutesPastStrategy strategy = new MinutesPastStrategy();

    @ParameterizedTest
    @ValueSource(ints = {45,30,15,50,49,0})
    void shouldNotSupportValueNotMinutesPast(Integer minute) {
        assertFalse(strategy.supports(minute));
    }


    @Test
    void shouldReturnMinutesPastHour() {
        assertTrue(strategy.supports(10));
        assertEquals("ten past three", strategy.convert(3, 10, words));
    }

    @Test
    void shouldReturnMinutesPastMidnight() {
        assertTrue(strategy.supports(5));
        assertEquals("five past midnight", strategy.convert(0, 5, words));
    }
}
