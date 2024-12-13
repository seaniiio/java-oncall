package oncall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import oncall.constant.ErrorMessage;
import oncall.domain.Date;
import oncall.domain.Employee;
import oncall.domain.HolidaySequence;
import oncall.domain.WeekdaySequence;
import oncall.util.Parser;

public class OncallService {

    private Date startDate;
    private WeekdaySequence weekdaySequence;
    private HolidaySequence holidaySequence;

    public void setMonthAndDayOfWeek(String monthAndDayOfWeekInput) {
        Map<Integer, String> parsedValue = Parser.parseMonthAndDayOfWeek(monthAndDayOfWeekInput);
        Set<Integer> month = parsedValue.keySet();
        for (Integer startMonth : month) {
            new Date(startMonth, parsedValue.get(startMonth));
        }
    }

    public void setWeekdaySequence(String weekdaySequenceInput) {
        List<String> employees = Parser.parseEmployee(weekdaySequenceInput);
        List<Employee> sequence = new ArrayList<>();
        for (String employee : employees) {
            sequence.add(new Employee(employee));
        }
        this.weekdaySequence = new WeekdaySequence(sequence);
    }

    public void setHolidaySequence(String holidaySequenceInput) {
        List<String> employees = Parser.parseEmployee(holidaySequenceInput);
        List<Employee> sequence = new ArrayList<>();
        for (String employee : employees) {
            sequence.add(new Employee(employee));
        }
        this.holidaySequence = new HolidaySequence(sequence);
    }

    public void validateSequence() {
        List<Employee> weekdayEmployees = this.weekdaySequence.getSequence();
        List<Employee> holidayEmployees = this.holidaySequence.getSequence();
        if (weekdayEmployees.size() != holidayEmployees.size()) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_CONSIST_ERROR.getMessage());
        }
        for (Employee holidayEmployee : holidayEmployees) {
            if (!weekdayEmployees.contains(holidayEmployee)) {
                throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_CONSIST_ERROR.getMessage());
            }
        }
    }

    public List<> assign() {

    }
}
