package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String monthAndDayOfWeekInput() {
        System.out.printf("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
        return Console.readLine();
    }

    public String weekdaySequenceInput() {
        System.out.printf("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        return Console.readLine();
    }

    public String holidaySequenceInput() {
        System.out.printf("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        return Console.readLine();
    }
}
