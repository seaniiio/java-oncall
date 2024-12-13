package oncall.dto;

public class WorkList {

    private final String employee;
    private final int month;
    private final int day;
    private final String dayOfWeek;
    private final boolean isHoliday;

    public WorkList(String employee, int month, int day, String dayOfWeek, boolean isHoliday) {
        this.employee = employee;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }
}
