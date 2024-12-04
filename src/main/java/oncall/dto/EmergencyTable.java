package oncall.dto;

import oncall.constant.DayOfWeek;
import oncall.constant.Holiday;
import oncall.constant.Month;
import oncall.domain.Employee;

public class EmergencyTable {

    private final Employee employee;
    private final Month month;
    private final int day;
    private final DayOfWeek dayOfWeek;

    public EmergencyTable(Employee employee, Month month, int day, DayOfWeek dayOfWeek) {
        this.employee = employee;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    @Override
    public String toString() {
        // 평일이면서 법정공휴일
        if (!dayOfWeek.isHoliday() && Holiday.isHoliday(month.getMonthNumber(), day)) {
            return month.getMonthNumber() + "월 "
                    + day + "일 "
                    + dayOfWeek.getName() + "(휴일) "
                    + employee.getName();
        }

        return month.getMonthNumber() + "월 "
                + day + "일 "
                + dayOfWeek.getName() + " "
                + employee.getName();
    }
}
