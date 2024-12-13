package oncall.domain;

import oncall.constant.ErrorMessage;

public enum DayOfWeek {

    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일"),
    ;

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public static DayOfWeek fromName(String name) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.name.equals(name)) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.START_DATE_ERROR.getMessage());
    }
}
