package org.andela.smartbear;

import java.util.Scanner;
import org.andela.smartbear.numbertoword.NumberToEnglishWords;
import org.andela.smartbear.numbertoword.NumberToWords;
import org.andela.smartbear.timeconverter.InvalidTimeInputException;
import org.andela.smartbear.timeconverter.TimeConverter;
import org.andela.smartbear.timeconverter.TimeToBritishConverter;

public class SmartBear {

    public static void main(final String[] args) {
        final NumberToWords numberToWords = new NumberToEnglishWords();
        final TimeConverter converter = new TimeToBritishConverter(numberToWords);

        final Scanner timeStringScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter time in 24 hour format format xx:xx (e.g 13:05). 'q' to quit ");
            final String timeString = timeStringScanner.nextLine();
            if (timeString.equals("q")) {
                System.out.println("Bye!!!");
                break;
            }
            try {
                System.out.println(converter.convertToWords(timeString));
            } catch (final InvalidTimeInputException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}
