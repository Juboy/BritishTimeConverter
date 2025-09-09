package org.andela.smartbear.timeconverter;

public class InvalidTimeInputException extends RuntimeException {

    public InvalidTimeInputException(final String message) {
        super(message);
    }
}
