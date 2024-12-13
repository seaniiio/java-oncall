package oncall.dto;

public class WorkList {

    private final String employee;
    private final int month;
    private final int day;
    private final String dayOfWeek;
    private final boolean isHoliday;
    private final boolean isWeekend;

    public WorkList(String employee, int month, int day, String dayOfWeek, boolean isHoliday, boolean isWeekend) {
        this.employee = employee;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
        this.isWeekend = isWeekend;
    }

    public String getMessage() {
        if (isHoliday && !isWeekend) {
            return String.format("%d월 %d일 %s(휴일) %s", month, day, dayOfWeek, employee);
        }
        return String.format("%d월 %d일 %s %s", month, day, dayOfWeek, employee);
    }
}
