package oncall.service;

import oncall.constant.DayOfWeek;
import oncall.constant.Month;

public class OncallService {

    public void setStartingPoint(String startingPointInput) {
        Month targetMonth = Parser.parseMonth(startingPointInput);
        DayOfWeek targetDayOfWeek = Parser.parseDayOfWeek(startingPointInput);
    }
}
