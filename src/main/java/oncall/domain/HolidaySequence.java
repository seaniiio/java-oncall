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
}
