package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HalfPastStrategyTest {

    private final NumberToWordsStrategy words = new NumberToEnglishWordsStrategy();
    private final HalfPastStrategy strategy = new HalfPastStrategy();


    @ParameterizedTest
    @ValueSource(ints = {45,20,15,14,12,0})
    void shouldNotSupportValueNotHalfPast(Integer minute) {
        assertFalse(strategy.supports(minute));
    }

    @Test
    void shouldReturnHalfPastMidnightWhenHourIsZero() {
        assertTrue(strategy.supports(30));
        assertEquals("half past midnight", strategy.convert(0, 30, words));
    }

    @Test
    void shouldReturnHalfPastHour() {
        assertTrue(strategy.supports(30));
        assertEquals("half past three", strategy.convert(3, 30, words));
    }
}
