package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinutesToStrategyTest {

    private final NumberToWordsStrategy words = new NumberToEnglishWordsStrategy();
    private final MinutesToStrategy strategy = new MinutesToStrategy();

    @ParameterizedTest
    @ValueSource(ints = {45,20,30,15,14,12,0})
    void shouldNotSupportValueNotMinutesTo(Integer minute) {
        assertFalse(strategy.supports(minute));
    }

    @Test
    void shouldReturnMinutesToNextHour() {
        assertTrue(strategy.supports(50));
        assertEquals("ten to four", strategy.convert(3, 50, words));
    }

    @Test
    void shouldWrapAroundToMidnight() {
        assertTrue(strategy.supports(50));
        assertEquals("ten to twelve", strategy.convert(23, 50, words));
    }
}
