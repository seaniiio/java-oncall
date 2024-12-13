package oncall.domain;

public class Date {

    private final Month month;
    private final DayOfWeek dayOfWeek;

    public Date(int month, String dayOfWeek) {
        this.month = Month.findByMonth(month);
        this.dayOfWeek = DayOfWeek.fromName(dayOfWeek);
    }

    public int getDaysInMonth() {
        return month.getDay();
    }

    public int getMonth() {
        return month.getMonth();
    }

    public DayOfWeek getDayOfWeekAfterDays(int day) {
        return DayOfWeek.findAfterDays(dayOfWeek, day);
    }
}
