package oncall.service;

import static org.junit.jupiter.api.Assertions.*;

import oncall.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OncallServiceTest {

    OncallService oncallService = new OncallService();

    @Test
    void 사원_이름_중복_입력_에외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> oncallService.setWeekdaySequence("벨,벨"))
                .withMessageContaining(ErrorMessage.EMPLOYEE_NAME_DUPLICATED_ERROR.getMessage());
    }
}
