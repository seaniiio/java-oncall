package oncall.service;

import java.util.Map;
import java.util.Set;
import oncall.domain.Date;
import oncall.util.Parser;

public class OncallService {

    private Date startDate;

    public void setMonthAndDayOfWeek(String monthAndDayOfWeekInput) {
        Map<Integer, String> parsedValue = Parser.parseMonthAndDayOfWeek(monthAndDayOfWeekInput);
        Set<Integer> month = parsedValue.keySet();
        for (Integer startMonth : month) {
            new Date(startMonth, parsedValue.get(startMonth));
        }
    }


}
