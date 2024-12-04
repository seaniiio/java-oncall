package oncall.service;

import static org.junit.jupiter.api.Assertions.*;

import oncall.constant.DayOfWeek;
import oncall.constant.ErrorMessage;
import oncall.constant.Month;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Test
    void 월_변환_테스트() {
        Assertions.assertThat(Parser.parseMonth("3,화"))
                .isEqualTo(Month.MARCH);
    }

    @Test
    void 미존재_월_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseMonth("13, 화"))
                .withMessageContaining(ErrorMessage.MONTH_NOT_EXIST_ERROR.getMessage());
    }

    @Test
    void 월_형식_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseMonth("1월, 화"))
                .withMessageContaining(ErrorMessage.MONTH_FORMAT_ERROR.getMessage());
    }

    @Test
    void 요일_변환_테스트() {
        Assertions.assertThat(Parser.parseDayOfWeek("1,수"))
                .isEqualTo(DayOfWeek.WEDNESDAY);
    }

    @Test
    void 미존재_요일_변환_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseDayOfWeek("1,월요일"))
                .withMessageContaining(ErrorMessage.DAY_OF_WEEK_NOT_EXIST_ERROR.getMessage());
    }
}
