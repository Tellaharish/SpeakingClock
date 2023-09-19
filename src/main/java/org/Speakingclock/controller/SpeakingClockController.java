package org.Speakingclock.controller;

import java.util.Scanner;

import org.Speakingclock.dto.SpeakingClock;
import org.Speakingclock.exception.CustomExceptionHandler;

public class SpeakingClockController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the time in 24-hour format (HH:mm) or type 'exit' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the Speaking Clock.");
                break;
            }

            try {
                String result = SpeakingClock.convertToWords(input);
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid Time Format " + e.getMessage());
            }
        }

        scanner.close();
    }
}
