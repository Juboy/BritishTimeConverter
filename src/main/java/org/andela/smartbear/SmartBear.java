package org.andela.smartbear;

import java.util.Scanner;
import org.andela.smartbear.timeconverter.TimeConverterStrategy;
import org.andela.smartbear.timeconverter.TimeToBritishConverterFactory;
import org.andela.smartbear.timeconverter.TimeToWordsFactory;
import org.andela.smartbear.timeconverter.exception.InvalidTimeInputException;

public class SmartBear {

    public static void main(final String[] args) {
        final TimeToWordsFactory timeToBritishConverterFactory = new TimeToBritishConverterFactory();
        final TimeConverterStrategy converter = timeToBritishConverterFactory.createTimeConverter();

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
