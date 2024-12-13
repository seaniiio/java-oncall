package oncall.domain;

import oncall.constant.ErrorMessage;

public enum DayOfWeek {

    MONDAY("월", false, 0),
    TUESDAY("화", false, 1),
    WEDNESDAY("수", false, 2),
    THURSDAY("목", false, 3),
    FRIDAY("금", false, 4),
    SATURDAY("토", true, 5),
    SUNDAY("일", true, 6),
    ;

    private final String name;
    private final boolean isWeekend;
    private final int sequence;

    DayOfWeek(String name, boolean isWeekend, int sequence) {
        this.name = name;
        this.isWeekend = isWeekend;
        this.sequence = sequence;
    }

    public static DayOfWeek fromName(String name) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.name.equals(name)) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.START_DATE_ERROR.getMessage());
    }

    public static DayOfWeek findAfterDays(DayOfWeek startDayOfWeek, int day) {
        return findBySequence((startDayOfWeek.sequence + (day - 1)) % 7);
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public String getName() {
        return name;
    }

    private static DayOfWeek findBySequence(int sequence) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.sequence == sequence) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.START_DATE_ERROR.getMessage());
    }
}
