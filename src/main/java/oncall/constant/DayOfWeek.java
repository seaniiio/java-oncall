package oncall.constant;

public enum DayOfWeek {

    MONDAY("월", false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true),
    SUNDAY("일", true);

    private final String name;
    private final boolean isHoliday;

    DayOfWeek(String name, boolean isHoliday) {
        this.name = name;
        this.isHoliday = isHoliday;
    }

    public static DayOfWeek getDayOfWeekByName(String name) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.name.equals(name)) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.DAY_OF_WEEK_NOT_EXIST_ERROR.getMessage());
    }
}
