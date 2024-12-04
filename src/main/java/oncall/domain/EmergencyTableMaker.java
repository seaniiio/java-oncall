package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.constant.DayOfWeek;
import oncall.constant.Holiday;
import oncall.constant.Month;
import oncall.dto.EmergencyTable;

public class EmergencyTableMaker {

    private final Month targetMonth;
    private final DayOfWeek targetDayOfWeek;

    public EmergencyTableMaker(Month targetMonth, DayOfWeek targetDayOfWeek) {
        this.targetMonth = targetMonth;
        this.targetDayOfWeek = targetDayOfWeek;
    }

    public List<EmergencyTable> assignEmergencyTable(WeekdaySequence weekdaySequence, HolidaySequence holidaySequence) {
        List<EmergencyTable> emergencyTables = new ArrayList<>();
        int weekdaySequenceOrder = 0;
        int holidaySequenceOrder = 0;

        for (int day = 1; day <= targetMonth.getDaysOfMonth(); day++) {
            DayOfWeek dayOfWeek = DayOfWeek.calculateDayOfWeek(targetDayOfWeek, day);

            if (!dayOfWeek.isHoliday() && !Holiday.isHoliday(targetMonth.getMonthNumber(), day)) {
                addWeekendSequenceWithReplace(weekdaySequence, weekdaySequenceOrder, emergencyTables, day, dayOfWeek);
                weekdaySequenceOrder += 1;
            }

            if (dayOfWeek.isHoliday() || Holiday.isHoliday(targetMonth.getMonthNumber(), day)) {
                addHolidaySequenceWithReplace(holidaySequence, holidaySequenceOrder, emergencyTables, day, dayOfWeek);
                holidaySequenceOrder += 1;
            }
        }

        return emergencyTables;
    }

    private void addWeekendSequenceWithReplace(WeekdaySequence weekdaySequence, int weekdaySequenceOrder,
                                 List<EmergencyTable> emergencyTables, int day, DayOfWeek dayOfWeek) {
        if (emergencyTables.isEmpty()) {
            Employee nowEmployee = weekdaySequence.getEmployeeOfOrder(weekdaySequenceOrder, false);
            emergencyTables.add(new EmergencyTable(nowEmployee, targetMonth, day, dayOfWeek));
            return;
        }

        Employee recentEmployee = emergencyTables.get(emergencyTables.size() - 1).getEmployee();
        Employee nowEmployee = weekdaySequence.getEmployeeOfOrder(weekdaySequenceOrder, false);

        if (recentEmployee.equals(nowEmployee)) {
            nowEmployee = weekdaySequence.getEmployeeOfOrder(weekdaySequenceOrder, true);
        }

        emergencyTables.add(new EmergencyTable(nowEmployee, targetMonth, day, dayOfWeek));
    }

    private void addHolidaySequenceWithReplace(HolidaySequence holidaySequence, int holidaySequenceOrder,
                                               List<EmergencyTable> emergencyTables, int day, DayOfWeek dayOfWeek) {
        if (emergencyTables.isEmpty()) {
            Employee nowEmployee = holidaySequence.getEmployeeOfOrder(holidaySequenceOrder, false);
            emergencyTables.add(new EmergencyTable(nowEmployee, targetMonth, day, dayOfWeek));
            return;
        }

        Employee recentEmployee = emergencyTables.get(emergencyTables.size() - 1).getEmployee();
        Employee nowEmployee = holidaySequence.getEmployeeOfOrder(holidaySequenceOrder, false);

        if (recentEmployee.equals(nowEmployee)) {
            nowEmployee = holidaySequence.getEmployeeOfOrder(holidaySequenceOrder, true);
        }

        emergencyTables.add(new EmergencyTable(nowEmployee, targetMonth, day, dayOfWeek));
    }

}
