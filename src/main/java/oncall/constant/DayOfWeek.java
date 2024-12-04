package oncall.constant;

public enum DayOfWeek {

    MONDAY("월", false, 0),
    TUESDAY("화", false, 1),
    WEDNESDAY("수", false, 2),
    THURSDAY("목", false, 3),
    FRIDAY("금", false, 4),
    SATURDAY("토", true, 5),
    SUNDAY("일", true, 6);

    private static final int SEVEN = 7;
    private final String name;
    private final boolean isHoliday;
    private final int sequence;

    DayOfWeek(String name, boolean isHoliday, int sequence) {
        this.name = name;
        this.isHoliday = isHoliday;
        this.sequence = sequence;
    }

    public static DayOfWeek getDayOfWeekByName(String name) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.name.equals(name)) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.DAY_OF_WEEK_NOT_EXIST_ERROR.getMessage());
    }

    public String getName() {
        return name;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public static DayOfWeek calculateDayOfWeek(DayOfWeek start, int days) {
        return findBySequence((start.sequence + days - 1) % SEVEN);
    }

    private static DayOfWeek findBySequence(int sequence) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.sequence == sequence) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.DAY_OF_WEEK_NOT_EXIST_ERROR.getMessage());
    }
}
