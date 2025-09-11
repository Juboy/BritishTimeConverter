package org.andela.smartbear.timeconverter.british;

import java.util.List;
import java.util.regex.Pattern;
import org.andela.smartbear.numbertoword.NumberToWordsStrategy;
import org.andela.smartbear.timeconverter.TimeConverterStrategy;
import org.andela.smartbear.timeconverter.exception.InvalidTimeInputException;

public class BritishTimeConverterStrategy implements TimeConverterStrategy {

    private final NumberToWordsStrategy numberToWordsStrategy;
    private final List<TimeExpressionStrategy> strategies = List.of(
            new OClockStrategy(),
            new HalfPastStrategy(),
            new QuarterPastStrategy(),
            new QuarterToStrategy(),
            new MinutesPastStrategy(),
            new MinutesToStrategy()
    );

    private static final Pattern TIME_PATTERN = Pattern.compile("^(?:[0-9]|[01]\\d|2[0-3]):[0-5]\\d$");

    public BritishTimeConverterStrategy(final NumberToWordsStrategy numberToWordsStrategy) {
        this.numberToWordsStrategy = numberToWordsStrategy;
    }

    /**
     * Returns time expression in words
     * @param time ':' separated time string in 24 hours format e.g 11:00
     * @return representation of a string in words
     */
    public String convertToWords(final String time) throws InvalidTimeInputException {

        validateTimeString(time);

        final String[] timeValues = time.trim().split(":");
        final int hourValue = Integer.parseInt(timeValues[0]);
        final int minuteValue = Integer.parseInt(timeValues[1]);

        return strategies.stream()
                .filter(s -> s.supports(minuteValue))
                .findFirst()
                .orElseThrow(() -> new InvalidTimeInputException("Unsupported time format"))
                .convert(hourValue, minuteValue, numberToWordsStrategy);

    }


    private void validateTimeString(final String time) {
        if (time == null || !TIME_PATTERN.matcher(time.trim()).matches()) {
            throw new InvalidTimeInputException("Invalid time format. Expected HH:mm (00:00 to 23:59).");
        }
    }
}
