package oncall.constant;

public enum Holiday {
    NEW_YEARS_DAY(1, 1),
    INDEPENDENCE_MOVEMENT_DAY(3, 1),
    CHILDRENS_DAY(5, 5),
    MEMORIAL_DAY(6,6),
    NATIONAL_LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_OF_KOREA(10, 3),
    HANGUL_PROCLAMATION_DAY(10, 9),
    CHRISTMAS(12, 25)
    ;

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }
}
