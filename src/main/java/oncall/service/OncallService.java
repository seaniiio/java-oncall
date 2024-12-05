package oncall.service;

import java.util.List;
import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import oncall.domain.EmergencyTableMaker;
import oncall.domain.Employees;
import oncall.domain.Sequence;
import oncall.dto.EmergencyTableDto;

public class OncallService {

    private Month targetMonth;
    private DayOfWeek targetDayOfWeek;
    private Employees employees;
    private Sequence weekdaySequence;
    private Sequence holidaySequence;

    public void setStartingPoint(String startingPointInput) {
        this.targetMonth = Parser.parseMonth(startingPointInput);
        this.targetDayOfWeek = Parser.parseDayOfWeek(startingPointInput);
    }

    public void setWeekdaySequence(String weekdaySequenceInput) {
        List<String> weekdayEmployees = Parser.parseEmployees(weekdaySequenceInput);

        this.employees = new Employees(weekdayEmployees);
        this.weekdaySequence = new Sequence(this.employees);
    }

    public void setHolidaySequence(String holidaySequenceInput) {
        List<String> holidayEmployees = Parser.parseEmployees(holidaySequenceInput);
        Employees holidayEmployeesSequence = new Employees(holidayEmployees);

        this.employees.compareEmployees(holidayEmployeesSequence);
        this.holidaySequence = new Sequence(holidayEmployeesSequence);
    }

    public List<EmergencyTableDto> assignTable() {
        EmergencyTableMaker emergencyTableMaker = new EmergencyTableMaker(targetMonth, targetDayOfWeek);
        return emergencyTableMaker.assignEmergencyTable(weekdaySequence, holidaySequence);
    }
}
