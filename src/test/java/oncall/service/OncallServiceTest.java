package oncall.service;

import static org.junit.jupiter.api.Assertions.*;

import oncall.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OncallServiceTest {

    OncallService oncallService = new OncallService();

    @Test
    void 사원_이름_중복_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> oncallService.setWeekdaySequence("김김,김김,시원,셔니,시옹"))
                .withMessageContaining(ErrorMessage.EMPLOYEE_DUPLICATED_ERROR.getMessage());
    }

    @Test
    void 사원_목록_일관성_예외_테스트() {
        oncallService.setWeekdaySequence("오션,로이스,애쉬,푸만능,우가");
        oncallService.setHolidaySequence("오션,로이스,애쉬,푸만능,시원");

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> oncallService.validateSequence())
                .withMessageContaining(ErrorMessage.EMPLOYEE_CONSIST_ERROR.getMessage());
    }
}
