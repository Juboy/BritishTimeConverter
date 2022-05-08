package org.andela.smartbear;

import org.andela.smartbear.numbertoword.NumberToEnglishWords;
import org.andela.smartbear.numbertoword.NumberToWords;
import org.andela.smartbear.timeconverter.TimeToBritishConverter;
import org.andela.smartbear.timeconverter.InvalidTimeInputException;
import org.andela.smartbear.timeconverter.TimeConverter;

import java.util.Scanner;

public class SmartBear {

    public static void main(String[] args) {
        NumberToWords numberToWords = new NumberToEnglishWords();
        TimeConverter converter = new TimeToBritishConverter(numberToWords);

        Scanner timeStringScanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter time in 24 hour format format xx:xx (e.g 13:05). 'q' to quit ");
            String timeString = timeStringScanner.nextLine();
            if(timeString.equals("q")){
                System.out.println("Bye!!!");
                break;
            }
            try{
                System.out.println(converter.convertToWords(timeString));
            }catch (InvalidTimeInputException ex){
                System.out.println(ex.getMessage());
            }

        }

    }

}
