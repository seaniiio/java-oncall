package oncall.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.constant.ErrorMessage;

public class WeekdaySequence {

    private final List<Employee> sequence;

    public WeekdaySequence(List<Employee> sequence) {
        validate(sequence);
        this.sequence = sequence;
    }

    public List<Employee> getSequence() {
        return new ArrayList<>(sequence);
    }

    private void validate(List<Employee> sequence) {
        if (sequence.size() < 5 || sequence.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_NUMBER_ERROR.getMessage());
        }

        Set<Employee> sequenceWithoutDuplicate = new HashSet<>(sequence);
        if (sequence.size() != sequenceWithoutDuplicate.size()) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_DUPLICATED_ERROR.getMessage());
        }
    }
}