package org.andela.smartbear.numbertoword;

import org.andela.smartbear.numbertoword.exception.InvalidNumberException;

public interface NumberToWordsStrategy {

    /**
     * Convert an Integer to its string equivalent (Must be between 0 and 999 inclusive)
     * @param number Integer value top convert
     * @return String equivalent of the passed Integer
     * @throws InvalidNumberException if number is less than 0 or greater than 1000
     */
    String convert(int number) throws InvalidNumberException;
}
