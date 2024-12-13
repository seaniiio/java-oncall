package oncall.domain;

public enum Holiday {

    NEW_YEARS_DAY(1, 1),
    SAMILJEOL(3, 1),
    CHILDRENS_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    CHRISTMAS(12, 25)
    ;

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        for (Holiday holiday : Holiday.values()) {
            if (holiday.day == day && holiday.month == month) {
                return true;
            }
        }
        return false;
    }
}
