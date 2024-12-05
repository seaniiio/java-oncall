package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.constant.DayOfWeek;
import oncall.constant.Holiday;
import oncall.constant.Month;
import oncall.dto.EmergencyTableDto;

public class EmergencyTableMaker {

    private final Month targetMonth;
    private final DayOfWeek targetDayOfWeek;

    public EmergencyTableMaker(Month targetMonth, DayOfWeek targetDayOfWeek) {
        this.targetMonth = targetMonth;
        this.targetDayOfWeek = targetDayOfWeek;
    }

    public List<EmergencyTableDto> assignEmergencyTable(Sequence weekdaySequence, Sequence holidaySequence) {
        List<EmergencyTableDto> emergencyTables = new ArrayList<>();
        setEmergencyTable(weekdaySequence, holidaySequence, emergencyTables);
        return emergencyTables;
    }

    private void setEmergencyTable(Sequence weekdaySequence, Sequence holidaySequence, List<EmergencyTableDto> emergencyTables) {
        int weekdaySequenceOrder = 0;
        int holidaySequenceOrder = 0;

        for (int day = 1; day <= targetMonth.getDaysOfMonth(); day++) {
            DayOfWeek dayOfWeek = DayOfWeek.calculateDayOfWeek(targetDayOfWeek, day);

            if (!dayOfWeek.isHoliday() && !Holiday.isHoliday(targetMonth.getMonthNumber(), day)) {
                addSequenceWithReplace(weekdaySequence, weekdaySequenceOrder, emergencyTables, day, dayOfWeek);
                weekdaySequenceOrder += 1;
            }
            if (dayOfWeek.isHoliday() || Holiday.isHoliday(targetMonth.getMonthNumber(), day)) {
                addSequenceWithReplace(holidaySequence, holidaySequenceOrder, emergencyTables, day, dayOfWeek);
                holidaySequenceOrder += 1;
            }
        }
    }

    private void addSequenceWithReplace(Sequence sequence, int sequenceOrder,
                                        List<EmergencyTableDto> emergencyTables, int day, DayOfWeek dayOfWeek) {
        if (emergencyTables.isEmpty()) {
            Employee nowEmployee = sequence.getEmployeeOfOrder(sequenceOrder, false);
            emergencyTables.add(new EmergencyTableDto(nowEmployee, targetMonth, day, dayOfWeek));
            return;
        }

        Employee recentEmployee = emergencyTables.get(emergencyTables.size() - 1).getEmployee();
        Employee nowEmployee = sequence.getEmployeeOfOrder(sequenceOrder, false);

        if (recentEmployee.equals(nowEmployee)) {
            nowEmployee = sequence.getEmployeeOfOrder(sequenceOrder, true);
        }

        emergencyTables.add(new EmergencyTableDto(nowEmployee, targetMonth, day, dayOfWeek));
    }
}
