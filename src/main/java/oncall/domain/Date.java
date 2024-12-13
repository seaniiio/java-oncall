package oncall.domain;

public class Date {

    private final Month month;
    private final DayOfWeek dayOfWeek;

    public Date(int month, String dayOfWeek) {
        this.month = Month.findByMonth(month);
        this.dayOfWeek = DayOfWeek.fromName(dayOfWeek);
    }
}
