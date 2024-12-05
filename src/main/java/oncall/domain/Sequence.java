package oncall.domain;

import java.util.List;

public class Sequence {

    private final List<Employee> holidaySequence;
    private boolean isReplaced;

    public Sequence(List<Employee> holidaySequence) {
        this.holidaySequence = holidaySequence;
        this.isReplaced = false;
    }

    public Employee getEmployeeOfOrder(int sequenceOrder, boolean isDuplicated) {
        if (this.isReplaced) {
            // 이전에 교체되어서 이전 사람을 보내야 하는 경우
            this.isReplaced = false;
            return holidaySequence.get(sequenceOrder - 1 % (holidaySequence.size()));
        }
        if (isDuplicated) {
            // 교체해야 하는 경우
            this.isReplaced = true;
            return holidaySequence.get(sequenceOrder + 1 % (holidaySequence.size()));
        }
        return holidaySequence.get(sequenceOrder % (holidaySequence.size()));
    }
}
