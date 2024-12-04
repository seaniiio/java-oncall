package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import oncall.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeesTest {

    @Test
    void 근무자_수_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Employees(List.of("벨", "션")))
                .withMessageContaining(ErrorMessage.EMPLOYEES_NUMBER_ERROR.getMessage());
    }

    @Test
    void 근무자_이름_중복_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Employees(List.of("벨", "벨")))
                .withMessageContaining(ErrorMessage.EMPLOYEE_NAME_DUPLICATED_ERROR.getMessage());
    }

    @Test
    void 근무자_일관성_예외_테스트() {
        Employees employees = new Employees(List.of("가", "나", "다", "라", "마"));
        Employees anotherEmployees = new Employees(List.of("가", "나", "다", "라", "셔니"));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> employees.compareEmployees(anotherEmployees))
                .withMessageContaining(ErrorMessage.EMPLOYEE_NOT_CONSISTENT_ERROR.getMessage());
    }

    @Test
    void 근무자_미배정_예외_테스트() {
        Employees employees = new Employees(List.of("가", "나", "다", "라", "마", "바"));
        Employees anotherEmployees = new Employees(List.of("가", "나", "다", "라", "마"));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> employees.compareEmployees(anotherEmployees))
                .withMessageContaining(ErrorMessage.EMPLOYEE_NOT_ASSIGNED_ERROR.getMessage());
    }
}
