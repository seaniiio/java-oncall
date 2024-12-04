package oncall.constant;

import java.util.Arrays;

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

    private final int monthNumber;
    private final int daysOfMonth;

    Month(int monthNumber, int daysOfMonth) {
        this.monthNumber = monthNumber;
        this.daysOfMonth = daysOfMonth;
    }

    public static Month getMonthByNumber(int number) {
        for (Month month : Month.values()) {
            if (month.monthNumber == number) {
                return month;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MONTH_NOT_EXIST_ERROR.getMessage());
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public int getDaysOfMonth() {
        return daysOfMonth;
    }
}
