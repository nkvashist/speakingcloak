package in.nks.speakingcloak.utilities;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import in.nks.speakingcloak.Exception.InvalidDataException;

@Component
public class TimeUtils {

	private static final String[] ONES_ENGLISH_ARRAY = { "zero", "one", "two", "three", "four", "five", "six", "seven",
			"eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen" };
	private static final String[] TENS_ENGLISH_ARRAY = { "", "", "twenty", "thirty", "forty", "fifty" };

	public void validateInput(String time) throws InvalidDataException {
		// validate that the time is not blank
		if (!StringUtils.hasText(time)) {
			throw new InvalidDataException("Time is blank");
		}

		// validate that the time is of the right format
		if (time.length() != 5 ) {
			throw new InvalidDataException("Invalid Time format, should be HH:mm");
		}
		
		// validate that the time is of the right format
		if (!time.contains(":")) {
			throw new InvalidDataException("Invalid Time format, should be HH:mm");
		}

		String[] timeSplit = time.split(":");

		// validate that the hours are an integer
		Integer hours = 0;
		try {
			hours = Integer.parseInt(timeSplit[0]);
		} catch (NumberFormatException e) {
			throw new InvalidDataException("Invalid Hours");
		}

		// validate that the hours are in the range
		if (hours < 0 || hours > 23) {
			throw new InvalidDataException("Invalid Hours");
		}

		// validate that the minutes are an integer
		Integer minutes = 0;
		try {
			minutes = Integer.parseInt(timeSplit[1]);
		} catch (NumberFormatException e) {
			throw new InvalidDataException("Invalid Minutes");
		}

		// validate that the minutes are in the range
		if (minutes < 0 || minutes > 59) {
			throw new InvalidDataException("Invalid Minutes");
		}
	}

	public String convertToEnglish(final Integer number) {
		if (number < 20)
			return ONES_ENGLISH_ARRAY[number];
		return TENS_ENGLISH_ARRAY[number / 10] + ((number % 10 > 0) ? " " + convertToEnglish(number % 10) : "");
	}

	public String checkMidDayOrNight(String time) {

		if (time.equalsIgnoreCase("00:00")) {
			return "It's Midnight";
		} else if (time.equalsIgnoreCase("12:00")) {
			return "It's Midday";
		} else {
			return null;
		}
	}

}
