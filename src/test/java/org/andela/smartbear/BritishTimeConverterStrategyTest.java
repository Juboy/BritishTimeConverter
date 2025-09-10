package org.andela.smartbear;

import org.andela.smartbear.numbertoword.NumberToEnglishWordsStrategy;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.andela.smartbear.timeconverter.exception.InvalidTimeInputException;
import org.andela.smartbear.timeconverter.TimeConverterStrategy;
import org.andela.smartbear.timeconverter.BritishTimeConverterStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BritishTimeConverterStrategyTest {

    private TimeConverterStrategy timeConverterStrategy;

    @BeforeEach
    public void setup(){
        NumberToWordsStrategy numberToWordsStrategy = new NumberToEnglishWordsStrategy();
        timeConverterStrategy = new BritishTimeConverterStrategy(numberToWordsStrategy);
    }

    static Stream<Arguments> provideTimeCases() {
        return Stream.of(
                // o’clock
                Arguments.of("13:00", "one o'clock"),
                Arguments.of("01:00", "one o'clock"),
                Arguments.of("15:00", "three o'clock"),
                Arguments.of("03:00", "three o'clock"),
                Arguments.of("18:00", "six o'clock"),
                Arguments.of("23:00", "eleven o'clock"),
                Arguments.of("11:00", "eleven o'clock"),

                // noon & midnight
                Arguments.of("12:00", "noon"),
                Arguments.of("00:00", "midnight"),

                // half past
                Arguments.of("00:30", "half past midnight"),
                Arguments.of("01:30", "half past one"),
                Arguments.of("13:30", "half past one"),
                Arguments.of("12:30", "half past twelve"),
                Arguments.of("06:30", "half past six"),
                Arguments.of("18:30", "half past six"),
                Arguments.of("03:30", "half past three"),
                Arguments.of("15:30", "half past three"),

                // quarter past
                Arguments.of("00:15", "quarter past midnight"),
                Arguments.of("01:15", "quarter past one"),
                Arguments.of("13:15", "quarter past one"),
                Arguments.of("12:15", "quarter past twelve"),
                Arguments.of("06:15", "quarter past six"),
                Arguments.of("18:15", "quarter past six"),
                Arguments.of("03:15", "quarter past three"),
                Arguments.of("15:15", "quarter past three"),

                // quarter to
                Arguments.of("00:45", "quarter to one"),
                Arguments.of("01:45", "quarter to two"),
                Arguments.of("13:45", "quarter to two"),
                Arguments.of("12:45", "quarter to one"),
                Arguments.of("06:45", "quarter to seven"),
                Arguments.of("18:45", "quarter to seven"),
                Arguments.of("03:45", "quarter to four"),
                Arguments.of("15:45", "quarter to four"),
                Arguments.of("11:45", "quarter to twelve"),

                // past times
                Arguments.of("00:05", "five past midnight"),
                Arguments.of("01:20", "twenty past one"),
                Arguments.of("13:10", "ten past one"),
                Arguments.of("12:14", "fourteen past twelve"),
                Arguments.of("06:29", "twenty nine past six"),
                Arguments.of("18:02", "two past six"),
                Arguments.of("03:23", "twenty three past three"),

                // to times
                Arguments.of("00:35", "twenty five to one"),
                Arguments.of("01:40", "twenty to two"),
                Arguments.of("13:50", "ten to two"),
                Arguments.of("12:44", "sixteen to one"),
                Arguments.of("06:39", "twenty one to seven"),
                Arguments.of("18:52", "eight to seven"),
                Arguments.of("03:33", "twenty seven to four"),
                Arguments.of("23:50", "ten to twelve")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTimeCases")
    public void testOClockTime(String input, String expectedOutput){
        assertEquals(expectedOutput, timeConverterStrategy.convertToWords(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1200",
            "12:000",
            "012:00",
            "12:0",
            "36:00",
            "4200",
            "12:80",
            "1:60"
    })
    public void testInvalidInputValidation(String input){
        assertThrows(InvalidTimeInputException.class, () -> timeConverterStrategy.convertToWords(input));
    }


}
