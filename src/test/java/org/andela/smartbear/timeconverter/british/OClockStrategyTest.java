package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OClockStrategyTest {

    private final NumberToWordsStrategy words = new NumberToEnglishWordsStrategy();
    private final OClockStrategy strategy = new OClockStrategy();

    @ParameterizedTest
    @ValueSource(ints = {40,20,30,15,14,12,59})
    void shouldNotSupportValueNotOClock(Integer minute) {
        assertFalse(strategy.supports(minute));
    }

    @Test
    void shouldReturnMidnightWhenHourIsZero() {
        assertTrue(strategy.supports(0));
        assertEquals("midnight", strategy.convert(0, 0, words));
    }

    @Test
    void shouldReturnNoonWhenHourIsTwelve() {
        assertTrue(strategy.supports(0));
        assertEquals("noon", strategy.convert(12, 0, words));
    }

    @Test
    void shouldReturnOClockForNormalHour() {
        assertTrue(strategy.supports(0));
        assertEquals("three o'clock", strategy.convert(3, 0, words));
    }
}
