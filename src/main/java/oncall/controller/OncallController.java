package oncall.controller;

import oncall.service.OncallService;
import oncall.util.InputProcessor;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final OncallService oncallService = new OncallService();

    public void run() {
        InputProcessor.continueUntilNormalInput(this::processStartDate, outputView::printErrorMessage);
        InputProcessor.continueUntilNormalInput(this::processSequence, outputView::printErrorMessage);
        oncallService.assign();
    }

    private void processSequence() {
        String weekdaySequenceInput = inputView.weekdaySequenceInput();
        oncallService.setWeekdaySequence(weekdaySequenceInput);

        String holidaySequenceInput = inputView.holidaySequenceInput();
        oncallService.setHolidaySequence(holidaySequenceInput);

        oncallService.validateSequence();
    }

    private void processStartDate() {
        String monthAndDayOfWeekInput = inputView.monthAndDayOfWeekInput();
        oncallService.setMonthAndDayOfWeek(monthAndDayOfWeekInput);
    }
}
