package oncall.constant;

public enum ErrorMessage {

    STARTING_POINT_FORMAT_ERROR("시작 시점의 입력 형식이 올바르지 않습니다."),
    MONTH_NOT_EXIST_ERROR("주어진 월 정보가 존재하지 않습니다."),
    MONTH_FORMAT_ERROR("월의 입력 형식이 올비르지 않습니다."),
    DAY_OF_WEEK_NOT_EXIST_ERROR("주어진 요일 정보가 존재하지 않습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
