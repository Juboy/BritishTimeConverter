package org.andela.smartbear.timeconverter;

public interface TimeConverter {

    /**
     * Returns time expression in words
     * @param time ':' separated time string in 24 hours format e.g 11:00
     * @return representation of a string in words
     */
    String convertToWords(String time) throws InvalidTimeInputException;
}
