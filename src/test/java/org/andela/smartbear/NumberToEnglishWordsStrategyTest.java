package org.andela.smartbear;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class NumberToEnglishWordsStrategyTest {

    private NumberToWordsStrategy numberToWordsStrategy;

    @BeforeEach
    public void setup(){
        numberToWordsStrategy = new NumberToEnglishWordsStrategy();
    }


    static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(11, "eleven"),
                Arguments.of(110, "one hundred ten"),
                Arguments.of(999, "nine hundred ninety nine"),
                Arguments.of(0, "zero")
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    public void testNumberToWords_successful(Integer input, String output){
        assertEquals(output, numberToWordsStrategy.convert(input));
    }

}
