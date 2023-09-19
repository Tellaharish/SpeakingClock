package org.jsp.merchent.exception;

public class CustomExceptionHandler {

    public static int parseInteger(String input) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Invalid number format entered", e);
        }
    }

    public static double parseDouble(String input) throws CustomNumberFormatException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Invalid number format entered", e);
        }
    }

    public static class CustomNumberFormatException extends Exception {
        public CustomNumberFormatException(String message, Throwable cause) {
            super(message, cause);
        }

        public CustomNumberFormatException(String message) {
            super(message);
        }
    }
}
