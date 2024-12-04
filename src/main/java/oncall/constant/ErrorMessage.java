package oncall.constant;

public enum ErrorMessage {

    STARTING_POINT_FORMAT_ERROR("시작 시점의 입력 형식이 올바르지 않습니다."),
    MONTH_NOT_EXIST_ERROR("주어진 월 정보가 존재하지 않습니다."),
    MONTH_FORMAT_ERROR("월의 입력 형식이 올비르지 않습니다."),
    DAY_OF_WEEK_NOT_EXIST_ERROR("주어진 요일 정보가 존재하지 않습니다."),

    EMPLOYEE_NAME_LENGTH_ERROR("사원의 이름은 0자에서 5자 사이여야 합니다."),
    EMPLOYEE_NAME_DUPLICATED_ERROR("중복된 사원의 이름이 존재합니다."),
    EMPLOYEE_NOT_ASSIGNED_ERROR("순서에 배정되지 않은 사원이 존재합니다."),
    EMPLOYEES_FORMAT_ERROR("순서 입력 형식이 올바르지 않습니다."),
    EMPLOYEES_NUMBER_ERROR("사원은 5명 이상 35명 이하여야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
