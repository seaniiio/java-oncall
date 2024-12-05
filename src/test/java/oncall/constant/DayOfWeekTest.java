package oncall.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DayOfWeekTest {

    @Test
    void 요일_이름으로_탐색_테스트() {
        Assertions.assertThat(DayOfWeek.getDayOfWeekByName("월"))
                .isEqualTo(DayOfWeek.MONDAY);
    }

    @Test
    void 요일_이름으로_탐색_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> DayOfWeek.getDayOfWeekByName("명"))
                .withMessageContaining(ErrorMessage.DAY_OF_WEEK_NOT_EXIST_ERROR.getMessage());
    }

    @Test
    void 날짜의_요일_계산_테스트() {
        Assertions.assertThat(DayOfWeek.calculateDayOfWeek(DayOfWeek.MONDAY, 3))
                .isEqualTo(DayOfWeek.WEDNESDAY);
    }
}
