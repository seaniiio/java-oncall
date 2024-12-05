package oncall.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MonthTest {

    @Test
    void 숫자로_월_탐색_테스트() {
        Assertions.assertThat(Month.getMonthByNumber(12))
                .isEqualTo(Month.DECEMBER);
    }

    @Test
    void 숫자로_월_탐색_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Month.getMonthByNumber(13))
                .withMessageContaining(ErrorMessage.MONTH_NOT_EXIST_ERROR.getMessage());
    }
}
