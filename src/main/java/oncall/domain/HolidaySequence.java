package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class HolidaySequence {

    private final List<Employee> holidaySequence;
    private int nextOrder;
    private boolean isReplaced;

    public HolidaySequence(List<Employee> holidaySequence) {
        this.holidaySequence = new ArrayList<>(holidaySequence);
        this.nextOrder = 0;
        this.isReplaced = false;
    }

    public Employee getEmployeeOfOrder(int holidaySequenceOrder, boolean isDuplicated) {
        if (this.isReplaced) {
            // 이전에 교체되어서 이전 사람을 보내야 하는 경우
            this.isReplaced = false;
            return holidaySequence.get(holidaySequenceOrder - 1 % (holidaySequence.size()));
        }
        if (isDuplicated) {
            // 교체해야 하는 경우
            this.isReplaced = true;
            return holidaySequence.get(holidaySequenceOrder + 1 % (holidaySequence.size()));
        }
        return holidaySequence.get(holidaySequenceOrder % (holidaySequence.size()));
    }
}
