package org.andela.smartbear;

import org.andela.smartbear.numbertoword.InvalidNumberException;
import org.andela.smartbear.numbertoword.NumberToEnglishWords;
import org.andela.smartbear.numbertoword.NumberToWords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberToWordsTest {

    private NumberToWords numberToWords;

    @BeforeEach
    public void setup(){
        numberToWords = new NumberToEnglishWords();
    }

    @Test
    public void testNumberToWords_successful(){
        assertEquals(numberToWords.convertIntegerToWords(11), " eleven");
        assertEquals(numberToWords.convertIntegerToWords(110), " one hundred ten");
        assertEquals(numberToWords.convertIntegerToWords(999), " nine hundred ninety nine");
        assertEquals(numberToWords.convertIntegerToWords(0), " zero");
    }

    @Test
    public void testNumberToWords_throwsExceptions(){
        assertThrows(InvalidNumberException.class, () -> numberToWords.convertIntegerToWords(2000));
        assertThrows(InvalidNumberException.class, () -> numberToWords.convertIntegerToWords(-1 ));
        assertThrows(InvalidNumberException.class, () -> numberToWords.convertIntegerToWords(null));
    }
}
