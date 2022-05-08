package org.andela.smartbear;

import org.andela.smartbear.numbertoword.NumberToEnglishWords;
import org.andela.smartbear.numbertoword.NumberToWords;
import org.andela.smartbear.timeconverter.InvalidTimeInputException;
import org.andela.smartbear.timeconverter.TimeConverter;
import org.andela.smartbear.timeconverter.TimeToBritishConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeToBritishConverterTest {

    private TimeConverter timeConverter;

    @BeforeEach
    public void setup(){
        NumberToWords numberToWords = new NumberToEnglishWords();
        timeConverter = new TimeToBritishConverter(numberToWords);
    }

    @Test
    public void testOClockTime(){
        assertEquals(timeConverter.convertToWords("13:00"), "one o'clock");
        assertEquals(timeConverter.convertToWords("01:00"), "one o'clock");
        assertEquals(timeConverter.convertToWords("15:00"), "three o'clock");
        assertEquals(timeConverter.convertToWords("03:00"), "three o'clock");
        assertEquals(timeConverter.convertToWords("18:00"), "six o'clock");
        assertEquals(timeConverter.convertToWords("23:00"), "eleven o'clock");
        assertEquals(timeConverter.convertToWords("11:00"), "eleven o'clock");
    }

    @Test
    public void testNoonTime(){
        assertEquals(timeConverter.convertToWords("12:00"), "noon");
    }

    @Test
    public void testMidnightTime(){
        assertEquals(timeConverter.convertToWords("00:00"), "midnight");
    }

    @Test
    public void testHalfPastTime(){
        assertEquals(timeConverter.convertToWords("00:30"), "half past midnight");
        assertEquals(timeConverter.convertToWords("01:30"), "half past one");
        assertEquals(timeConverter.convertToWords("13:30"), "half past one");
        assertEquals(timeConverter.convertToWords("12:30"), "half past twelve");
        assertEquals(timeConverter.convertToWords("06:30"), "half past six");
        assertEquals(timeConverter.convertToWords("18:30"), "half past six");
        assertEquals(timeConverter.convertToWords("03:30"), "half past three");
        assertEquals(timeConverter.convertToWords("15:30"), "half past three");
    }

    @Test
    public void testQuarterPastTime(){
        assertEquals(timeConverter.convertToWords("00:15"), "quarter past midnight");
        assertEquals(timeConverter.convertToWords("01:15"), "quarter past one");
        assertEquals(timeConverter.convertToWords("13:15"), "quarter past one");
        assertEquals(timeConverter.convertToWords("12:15"), "quarter past twelve");
        assertEquals(timeConverter.convertToWords("06:15"), "quarter past six");
        assertEquals(timeConverter.convertToWords("18:15"), "quarter past six");
        assertEquals(timeConverter.convertToWords("03:15"), "quarter past three");
        assertEquals(timeConverter.convertToWords("15:15"), "quarter past three");
    }

    @Test
    public void testQuarterToTime(){
        assertEquals(timeConverter.convertToWords("00:45"), "quarter to one");
        assertEquals(timeConverter.convertToWords("01:45"), "quarter to two");
        assertEquals(timeConverter.convertToWords("13:45"), "quarter to two");
        assertEquals(timeConverter.convertToWords("12:45"), "quarter to one");
        assertEquals(timeConverter.convertToWords("06:45"), "quarter to seven");
        assertEquals(timeConverter.convertToWords("18:45"), "quarter to seven");
        assertEquals(timeConverter.convertToWords("03:45"), "quarter to four");
        assertEquals(timeConverter.convertToWords("15:45"), "quarter to four");
        assertEquals(timeConverter.convertToWords("11:45"), "quarter to twelve");
    }

    @Test
    public void testPastTime(){
        assertEquals(timeConverter.convertToWords("00:05"), "five past midnight");
        assertEquals(timeConverter.convertToWords("01:20"), "twenty past one");
        assertEquals(timeConverter.convertToWords("13:10"), "ten past one");
        assertEquals(timeConverter.convertToWords("12:14"), "fourteen past twelve");
        assertEquals(timeConverter.convertToWords("06:29"), "twenty nine past six");
        assertEquals(timeConverter.convertToWords("18:02"), "two past six");
        assertEquals(timeConverter.convertToWords("03:23"), "twenty three past three");
    }

    @Test
    public void testToTime(){
        assertEquals(timeConverter.convertToWords("00:35"), "twenty five to one");
        assertEquals(timeConverter.convertToWords("01:40"), "twenty to two");
        assertEquals(timeConverter.convertToWords("13:50"), "ten to two");
        assertEquals(timeConverter.convertToWords("12:44"), "sixteen to one");
        assertEquals(timeConverter.convertToWords("06:39"), "twenty one to seven");
        assertEquals(timeConverter.convertToWords("18:52"), "eight to seven");
        assertEquals(timeConverter.convertToWords("03:33"), "twenty seven to four");
        assertEquals(timeConverter.convertToWords("23:50"), "ten to twelve");
    }
    
    @Test
    public void testInvalidInputValidation(){
        //must have semi colon
        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("1200"));

        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("12:000"));
        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("012:00"));
        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("12:0"));
        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("36:00"));
        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("4200"));
        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("12:80"));
        assertThrows(InvalidTimeInputException.class, () -> timeConverter.convertToWords("1:60"));

    }


}
