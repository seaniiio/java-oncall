package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SequenceTest {

    @ParameterizedTest
    @CsvSource({
            "시원, 2, false",
            "셔니, 2, true" // 교체 시 다음 순서와 바꿈
    })
    void 다음_근무자_탐색_테스트(String name, int sequenceOrder, boolean isReplaced) {
        Employees employees = new Employees(List.of("루루", "수아", "시원", "셔니", "노랑"));
        Sequence sequence = new Sequence(employees);
        String expectedEmployeeName = name;

        Assertions.assertThat(sequence.getEmployeeOfOrder(sequenceOrder, isReplaced).getName())
                .isEqualTo(expectedEmployeeName);
    }
}
