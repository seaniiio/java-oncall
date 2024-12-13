package oncall.constant;

public enum ErrorMessage {

    START_DATE_ERROR("입력한 월 혹은 시작 요일이 올바르지 않습니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
