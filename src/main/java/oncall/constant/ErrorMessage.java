package oncall.constant;

public enum ErrorMessage {

    START_DATE_ERROR("입력한 월 혹은 시작 요일이 올바르지 않습니다."),
    EMPLOYEE_NAME_ERROR("근무자의 이름은 1자 이상 5자 이하여야 합니다."),
    EMPLOYEE_NUMBER_ERROR("근무자는 5명 이상 35명 이하여야 합니다."),
    EMPLOYEE_DUPLICATED_ERROR("동일한 이름의 근무자가 존재합니다."),
    EMPLOYEE_CONSIST_ERROR("근무자 목록이 일관되지 않습니다.."),
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
