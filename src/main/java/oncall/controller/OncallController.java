package oncall.controller;

import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final OncallService oncallService = new OncallService();

    public void run() {
        String monthAndDayOfWeekInput = inputView.monthAndDayOfWeekInput();
        oncallService.setMonthAndDayOfWeek(monthAndDayOfWeekInput);

        String weekdaySequenceInput = inputView.weekdaySequenceInput();
        oncallService.setWeekdaySequence(weekdaySequenceInput);

        String holidaySequenceInput = inputView.holidaySequenceInput();
        oncallService.setHolidaySequence(holidaySequenceInput);

        oncallService.validateSequence();
    }
}
