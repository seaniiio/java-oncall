package oncall.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oncall.constant.ErrorMessage;

public class Parser {
    public static Map<Integer, String> parseMonthAndDayOfWeek(String monthAndDayOfWeekInput) {
        HashMap<Integer, String> parsedValue = new HashMap<>();
        try {
            String[] values = monthAndDayOfWeekInput.split(",");
            int month = Integer.parseInt(values[0]);
            String dayOfWeek = values[1];
            parsedValue.put(month, dayOfWeek);
            return parsedValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.START_DATE_ERROR.getMessage());
        }
    }

    public static List<String> parseEmployee(String weekdaySequenceInput) {
        return Arrays.stream(weekdaySequenceInput.split(",")).toList();
    }
}
