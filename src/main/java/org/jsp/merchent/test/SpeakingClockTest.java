package org.jsp.merchent.test;
import static org.junit.jupiter.api.Assertions.*;

import org.jsp.merchent.dto.SpeakingClock;
import org.jsp.merchent.exception.CustomExceptionHandler;
import org.junit.jupiter.api.Test;

public class SpeakingClockTest {

    @Test
    public void testValidTimeConversion() throws CustomExceptionHandler.CustomNumberFormatException {
        String time1 = "12:30";
        String time2 = "08:15";

        assertEquals("It's twelve thirty", SpeakingClock.convertToWords(time1));
        assertEquals("It's eight fifteen", SpeakingClock.convertToWords(time2));
    }

    @Test
    public void testMiddayAndMidnight() throws CustomExceptionHandler.CustomNumberFormatException {
        String midday = "12:00";
        String midnight = "00:00";

        assertEquals("It's Midday", SpeakingClock.convertToWords(midday));
        assertEquals("It's Midnight", SpeakingClock.convertToWords(midnight));
    }

    @Test
    public void testInvalidTimeFormat() {
        String invalidTime = "abc";

        assertThrows(CustomExceptionHandler.CustomNumberFormatException.class, () -> {
            SpeakingClock.convertToWords(invalidTime);
        });
    }

    @Test
    public void testInvalidTimeValue() {
        String invalidTime = "25:60";

        assertThrows(CustomExceptionHandler.CustomNumberFormatException.class, () -> {
            SpeakingClock.convertToWords(invalidTime);
        });
    }
}
