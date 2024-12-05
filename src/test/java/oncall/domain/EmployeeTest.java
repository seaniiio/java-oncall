package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import oncall.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EmployeeTest {

    @ParameterizedTest
    @ValueSource(strings = {"6글자입니다", " ", "", "\n"})
    void 근무자_이름_예외_테스트(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Employee(name))
                .withMessageContaining(ErrorMessage.EMPLOYEE_NAME_LENGTH_ERROR.getMessage());
    }
}
