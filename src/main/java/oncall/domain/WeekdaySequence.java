package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WeekdaySequence {

    private final List<Employee> weekdaySequence;
    private int nextOrder;
    private boolean isReplaced;

    public WeekdaySequence(List<Employee> weekdaySequence) {
        this.weekdaySequence = new ArrayList<>(weekdaySequence);
        this.nextOrder = 0;
        this.isReplaced = false;
    }

    public Employee getEmployeeOfOrder(int weekdaySequenceOrder, boolean isDuplicated) {
        if (this.isReplaced) {
            // 이전에 교체되어서 이전 사람을 보내야 하는 경우
            this.isReplaced = false;
            return weekdaySequence.get(weekdaySequenceOrder - 1 % (weekdaySequence.size()));
        }
        if (isDuplicated) {
            // 교체해야 하는 경우
            this.isReplaced = true;
            return weekdaySequence.get(weekdaySequenceOrder + 1 % (weekdaySequence.size()));
        }
        return weekdaySequence.get(weekdaySequenceOrder % (weekdaySequence.size()));
    }
}
