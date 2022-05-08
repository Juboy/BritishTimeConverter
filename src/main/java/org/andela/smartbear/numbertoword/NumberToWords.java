package org.andela.smartbear.numbertoword;

public interface NumberToWords {

    /**
     * Convert an Integer to its string equivalent (Must be between 0 and 999 inclusive)
     * @param number Integer value top convert
     * @return String equivalent of the passed Integer
     * @throws InvalidNumberException if number is less than 0 or greater than 1000
     */
    String convertIntegerToWords(Integer number) throws InvalidNumberException;
}
