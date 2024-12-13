package oncall.domain;

import oncall.constant.ErrorMessage;

public enum Month {

    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);
    ;

    private final int month;
    private final int day;

    Month(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static Month findByMonth(int monthInput) {
        for (Month month : Month.values()) {
            if (month.month == monthInput) {
                return month;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.START_DATE_ERROR.getMessage());
    }

    public int getDay() {
        return day;
    }
}
