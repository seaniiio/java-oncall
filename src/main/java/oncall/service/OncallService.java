package oncall.service;

import java.util.List;
import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import oncall.domain.EmergencyTableMaker;
import oncall.domain.Employees;
import oncall.domain.HolidaySequence;
import oncall.domain.WeekdaySequence;
import oncall.dto.EmergencyTable;

public class OncallService {

    private Month targetMonth;
    private DayOfWeek targetDayOfWeek;
    private Employees employees;
    private WeekdaySequence weekdaySequence;
    private HolidaySequence holidaySequence;

    public void setStartingPoint(String startingPointInput) {
        this.targetMonth = Parser.parseMonth(startingPointInput);
        this.targetDayOfWeek = Parser.parseDayOfWeek(startingPointInput);
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

    public List<EmergencyTable> assignTable() {
        EmergencyTableMaker emergencyTableMaker = new EmergencyTableMaker(targetMonth, targetDayOfWeek);
        return emergencyTableMaker.assignEmergencyTable(weekdaySequence, holidaySequence);
    }
}
