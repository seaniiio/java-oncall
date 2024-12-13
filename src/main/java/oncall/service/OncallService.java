package oncall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import oncall.constant.ErrorMessage;
import oncall.domain.Date;
import oncall.domain.Employee;
import oncall.domain.Holiday;
import oncall.domain.Sequence;
import oncall.dto.WorkList;
import oncall.util.Parser;

public class OncallService {

    private Date startDate;
    private Sequence weekdaySequence;
    private Sequence holidaySequence;

    public void setMonthAndDayOfWeek(String monthAndDayOfWeekInput) {
        Map<Integer, String> parsedValue = Parser.parseMonthAndDayOfWeek(monthAndDayOfWeekInput);
        Set<Integer> month = parsedValue.keySet();
        for (Integer startMonth : month) {
            this.startDate = new Date(startMonth, parsedValue.get(startMonth));
        }
    }

    public void setWeekdaySequence(String weekdaySequenceInput) {
        List<String> employees = Parser.parseEmployee(weekdaySequenceInput);
        List<Employee> sequence = new ArrayList<>();
        for (String employee : employees) {
            sequence.add(new Employee(employee));
        }
        this.weekdaySequence = new Sequence(sequence);
    }

    public void setHolidaySequence(String holidaySequenceInput) {
        List<String> employees = Parser.parseEmployee(holidaySequenceInput);
        List<Employee> sequence = new ArrayList<>();
        for (String employee : employees) {
            sequence.add(new Employee(employee));
        }
        this.holidaySequence = new Sequence(sequence);
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

    public List<WorkList> assign() {
        List<WorkList> workLists = new ArrayList<>();
        int month = startDate.getMonth();
        Employee latestEmployee = null;
        for (int nowDay = 1; nowDay <= startDate.getDaysInMonth(); nowDay++) {
            boolean isHoliday = checkHoliday(month, nowDay);
            Employee employee = getNextEmployee(isHoliday, latestEmployee);
            workLists.add(new WorkList(employee.getName(), month, nowDay,
                    startDate.getDayOfWeekAfterDays(nowDay).getName(),
                    isHoliday, startDate.getDayOfWeekAfterDays(nowDay).isWeekend()));
            latestEmployee = employee;
        }
        return workLists;
    }

    private Employee getNextEmployee(boolean isHoliday, Employee latestEmployee) {
        if (isHoliday) {
            return holidaySequence.getNextEmployee(latestEmployee);
        }
        return weekdaySequence.getNextEmployee(latestEmployee);
    }

    private boolean checkHoliday(int month, int day) {
        // 주말이거나, 공휴일
        if (Holiday.isHoliday(month, day)) {
            return true;
        }
        if (startDate.getDayOfWeekAfterDays(day).isWeekend()) {
            return true;
        }
        return false;
    }
}
