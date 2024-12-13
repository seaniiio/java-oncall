package oncall.domain;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import oncall.constant.ErrorMessage;

public class Sequence {

    private final Deque<Employee> sequence;

    public Sequence(List<Employee> sequence) {
        validate(sequence);
        this.sequence = new LinkedList<>(sequence);
    }

    public List<Employee> getSequence() {
        return new ArrayList<>(sequence);
    }

    public Employee getNextEmployee(Employee beforeEmployee) {
        Employee nextEmployee = sequence.removeFirst();
        if (beforeEmployee == null || !beforeEmployee.equals(nextEmployee)) {
            sequence.add(nextEmployee);
            return nextEmployee;
        }
        // 다음 근무자를 땡겨야 하는 경우
        Employee alternativeEmployee = sequence.removeFirst();
        sequence.addLast(alternativeEmployee);
        sequence.addFirst(nextEmployee);
        return alternativeEmployee;
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
