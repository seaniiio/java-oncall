package oncall.service;

import java.util.List;
import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import oncall.domain.Employee;
import oncall.domain.Employees;
import oncall.domain.WeekdaySequence;

public class OncallService {

    private Employees employees;
    private WeekdaySequence weekdaySequence;

    public void setStartingPoint(String startingPointInput) {
        Month targetMonth = Parser.parseMonth(startingPointInput);
        DayOfWeek targetDayOfWeek = Parser.parseDayOfWeek(startingPointInput);
    }

    public void setWeekdaySequence(String weekdaySequenceInput) {
        List<String> employees = Parser.parseEmployees(weekdaySequenceInput);

        this.employees = new Employees(employees);

        this.weekdaySequence = new WeekdaySequence(this.employees.getEmployees());
    }
}
