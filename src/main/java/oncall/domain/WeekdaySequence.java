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
}
