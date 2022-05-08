package org.andela.smartbear.timeconverter;

public class InvalidTimeInputException extends RuntimeException{

    public InvalidTimeInputException(String message) {
        super(message);
    }
}
