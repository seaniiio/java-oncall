package oncall.service;

import java.util.List;
import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import oncall.domain.Employee;
import oncall.domain.Employees;
import oncall.domain.HolidaySequence;
import oncall.domain.WeekdaySequence;

public class OncallService {

    private Employees employees;
    private WeekdaySequence weekdaySequence;
    private HolidaySequence holidaySequence;

    public void setStartingPoint(String startingPointInput) {
        Month targetMonth = Parser.parseMonth(startingPointInput);
        DayOfWeek targetDayOfWeek = Parser.parseDayOfWeek(startingPointInput);
    }

    public void setWeekdaySequence(String weekdaySequenceInput) {
        List<String> weekdayEmployees = Parser.parseEmployees(weekdaySequenceInput);

        this.employees = new Employees(weekdayEmployees);
        this.weekdaySequence = new WeekdaySequence(this.employees.getEmployees());
    }

    public void setHolidaySequence(String holidaySequenceInput) {
        List<String> holidayEmployees = Parser.parseEmployees(holidaySequenceInput);
        Employees holidayEmployeesSequence = new Employees(holidayEmployees);

        this.employees.compareEmployees(holidayEmployeesSequence);
        this.holidaySequence = new HolidaySequence(holidayEmployeesSequence.getEmployees());
    }
}
