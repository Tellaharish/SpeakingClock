package org.Speakingclock.dto;

import java.util.Scanner;

public class SpeakingClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the time in 24-hour format (HH:mm): ");
        String input = scanner.next();

        String result = convertToWords(input);
        System.out.println(result);

        scanner.close();
    }

    public static String convertToWords(String inputTime) {
        String[] parts = inputTime.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        if (hours == 12 && minutes == 0) {
            return "It's Midday";
        } else if (hours == 0 && minutes == 0) {
            return "It's Midnight";
        } else {
            String hourWords = getHourWords(hours);
            String minuteWords = getMinuteWords(minutes);
            return "It's " + hourWords + " " + minuteWords;
        }
    }

    public static String getHourWords(int hours) {
        String[] hourNames = {
            "twelve", "one", "two", "three", "four", "five", 
            "six", "seven", "eight", "nine", "ten", "eleven", "twelve"
        };
        
        if (hours >= 13) {
            hours -= 12;
        }

        return hourNames[hours];
    }

    public static String getMinuteWords(int minutes) {
        if (minutes == 0) {
            return "";
        } else if (minutes <= 9) {
            return "zero" + getDigitWords(minutes);
        } else if (minutes <= 19) {
            return getTeenWords(minutes);
        } else {
            int tens = minutes / 10;
            int ones = minutes % 10;
            return getTensWords(tens) + " " + getDigitWords(ones);
        }
    }

    public static String getTeenWords(int number) {
        String[] teenNames = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
        };
        return teenNames[number - 10];
    }

    public static String getTensWords(int number) {
        String[] tensNames = {
            "", "", "twenty", "thirty", "forty", "fifty"
        };
        return tensNames[number];
    }

    public static String getDigitWords(int number) {
        String[] digitNames = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        return digitNames[number];
    }
}
