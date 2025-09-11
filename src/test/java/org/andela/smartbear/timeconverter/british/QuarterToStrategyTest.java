package org.andela.smartbear.timeconverter.british;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuarterToStrategyTest {

    private final NumberToWordsStrategy words = new NumberToEnglishWordsStrategy();
    private final QuarterToStrategy strategy = new QuarterToStrategy();

    @ParameterizedTest
    @ValueSource(ints = {40,20,30,15,14,12,59})
    void shouldNotSupportValueNotQuarterTo(Integer minute) {
        assertFalse(strategy.supports(minute));
    }

    @Test
    void shouldReturnQuarterToNextHour() {
        assertTrue(strategy.supports(45));
        assertEquals("quarter to four", strategy.convert(3, 45, words));
    }

    @Test
    void shouldWrapAroundMidnight() {
        assertTrue(strategy.supports(45));
        assertEquals("quarter to twelve", strategy.convert(23, 45, words));
    }
}
