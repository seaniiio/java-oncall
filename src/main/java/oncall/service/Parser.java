package oncall.service;

import oncall.constant.DayOfWeek;
import oncall.constant.ErrorMessage;
import oncall.constant.Month;

public class Parser {

    private static final int MONTH_INDEX = 0;
    private static final int DAY_OF_WEEK_INDEX = 1;

    public static Month parseMonth(String startingPointInput) {
        String[] startingPoints;
        startingPoints = splitStartingPoint(startingPointInput);

        int monthNumber;
        try {
            monthNumber = Integer.parseInt(startingPoints[MONTH_INDEX]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MONTH_FORMAT_ERROR.getMessage());
        }

        return Month.getMonthByNumber(monthNumber);
    }

    public static DayOfWeek parseDayOfWeek(String startingPointInput) {
        String[] startingPoints;
        startingPoints = splitStartingPoint(startingPointInput);

        String dayOfWeek = startingPoints[DAY_OF_WEEK_INDEX];
        return DayOfWeek.getDayOfWeekByName(dayOfWeek);
    }

    private static String[] splitStartingPoint(String startingPointInput) {
        String[] startingPoints;
        try {
            startingPoints = startingPointInput.split(",");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.STARTING_POINT_FORMAT_ERROR.getMessage());
        }
        return startingPoints;
    }
}
