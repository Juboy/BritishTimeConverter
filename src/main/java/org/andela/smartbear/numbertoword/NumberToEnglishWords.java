package org.andela.smartbear.numbertoword;

public class NumberToEnglishWords implements NumberToWords {

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    /**
     * Convert an Integer to its string equivalent (Must be between 0 and 999 inclusive)
     * @param number Integer value top convert
     * @return String equivalent of the passed Integer
     * @throws InvalidNumberException if number is less than 0 or greater than 1000
     */
    public String convertIntegerToWords(Integer number) throws InvalidNumberException {
        if(number == null || number >= 1000){
            throw new InvalidNumberException("Invalid number: Number must not be null or less than 1000");
        }
        if(number < 0){
            throw new InvalidNumberException("Invalid number: Number must be a positive integer");
        }
        if(number == 0) return " zero";
        String soFar;

        if (number % 100 < 20){
            soFar = numNames[number % 100];
            number /= 100;
        }
        else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
    }
}
