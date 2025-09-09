package org.andela.smartbear.timeconverter;

import org.andela.smartbear.numbertoword.NumberToWords;

public class TimeToBritishConverter implements TimeConverter {

    private final NumberToWords numberToWords;

    public TimeToBritishConverter(NumberToWords numberToWords) {
        this.numberToWords = numberToWords;
    }

    /**
     * Returns time expression in words
     * @param time ':' separated time string in 24 hours format e.g 11:00
     * @return representation of a string in words
     */
    public String convertToWords(String time) throws InvalidTimeInputException {

        validateTimeString(time);

        String[] timeValues = time.trim().split(":");
        int hourValue = Integer.parseInt(timeValues[0]);
        int minuteValue = Integer.parseInt(timeValues[1]);

        int toHourValue = (hourValue + 1) % 12 == 0 ? 12 : (hourValue + 1) % 12;
        int pastHourValue = hourValue % 12 == 0 ? 12 : hourValue % 12;

        //take care of special minute cases 0, 30, 45
        if(minuteValue == 0){
            if(hourValue == 0) return "midnight";
            if(hourValue == 12) return "noon";
            String hourString = numberToWords.convertIntegerToWords(pastHourValue).trim();
            return hourString + " o'clock";
        }

        if(minuteValue == 30){
            if(hourValue == 0) return "half past midnight";
            String hourString = numberToWords.convertIntegerToWords(pastHourValue).trim();
            return "half past " + hourString;
        }

        if(minuteValue == 15){
            if(hourValue == 0) return "quarter past midnight";
            String hourString = numberToWords.convertIntegerToWords(pastHourValue).trim();
            return "quarter past " + hourString;
        }

        if(minuteValue == 45){
            String hourString = numberToWords.convertIntegerToWords(toHourValue).trim();
            return "quarter to " + hourString;
        }

        if(minuteValue < 30){
            String minuteString = numberToWords.convertIntegerToWords(minuteValue).trim();
            String hourString = hourValue == 0 ? "midnight" : numberToWords.convertIntegerToWords(pastHourValue).trim();
            return minuteString + " past " + hourString;
        } else {
            int minuteOffset = 60 - minuteValue;
            String minuteOffsetString = numberToWords.convertIntegerToWords(minuteOffset).trim();
            String hourString = numberToWords.convertIntegerToWords(toHourValue).trim();
            return minuteOffsetString + " to " + hourString;
        }
    }


    private void validateTimeString(String time){
        if(!time.contains(":")){
            throw new InvalidTimeInputException("Invalid time input: hour and minute string must be separated with ':'");
        }
        String[] timeValues = time.trim().split(":");
        if(timeValues.length != 2){
            throw new InvalidTimeInputException("Invalid time input: hour and minute string must be separated with only one colon ':'");
        }
        if(timeValues[0].length()> 2){
            throw new InvalidTimeInputException("Invalid time input: hour string length should not be greater that 2");
        }
        if(timeValues[1].length() != 2){
            throw new InvalidTimeInputException("Invalid time input: minute string must be of length 2");
        }

        int hourValue;
        int minuteValue;
        try {
            hourValue = Integer.parseInt(timeValues[0]);
            minuteValue = Integer.parseInt(timeValues[1]);
        }catch (NumberFormatException ex){
            throw new InvalidTimeInputException("Time string must be in number format only");
        }

        if(hourValue > 23 || hourValue < 0){
            throw new InvalidTimeInputException("Invalid time input: hour value must be between 0 and 23 (inclusive)");
        }
        if(minuteValue > 59 || minuteValue < 0){
            throw new InvalidTimeInputException("Invalid time input: minute value be between 0 and 59 (inclusive)");
        }
    }
}
