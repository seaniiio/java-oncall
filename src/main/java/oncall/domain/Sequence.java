package oncall.domain;

public class Sequence {

    private final Employees sequence;
    private boolean isReplaced;

    public Sequence(Employees sequence) {
        this.sequence = sequence;
        this.isReplaced = false;
    }

    public Employee getEmployeeOfOrder(int sequenceOrder, boolean isDuplicated) {
        if (this.isReplaced) {
            // 이전에 교체되어서 이전 사람을 보내야 하는 경우
            this.isReplaced = false;
            return sequence.getEmployeeOfOrder(sequenceOrder - 1);
        }
        if (isDuplicated) {
            // 교체해야 하는 경우
            this.isReplaced = true;
            return sequence.getEmployeeOfOrder(sequenceOrder + 1);
        }
        return sequence.getEmployeeOfOrder(sequenceOrder);
    }
}
