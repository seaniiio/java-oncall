package oncall.util;

import static org.junit.jupiter.api.Assertions.*;

import oncall.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1월, 5-월, \n"})
    void 시작_날짜_입력_예외_테스트(String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseMonthAndDayOfWeek(input))
                .withMessageContaining(ErrorMessage.START_DATE_ERROR.getMessage());
    }
}
