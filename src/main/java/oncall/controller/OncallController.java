package oncall.controller;

import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final InputView inputView;
    private final OutputView outputView;
    private final OncallService oncallService;

    public OncallController(final InputView inputView, final OutputView outputView, final OncallService oncallService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.oncallService = oncallService;
    }

    public void run() {
        String startingPointInput = inputView.startingPointInput();
        oncallService.setStartingPoint(startingPointInput);

        String weekdaySequenceInput = inputView.weekdaySequenceInput();
        oncallService.setWeekdaySequence(weekdaySequenceInput);

        String holidaySequenceInput = inputView.holidaySequenceInput();
        oncallService.setHolidaySequence(holidaySequenceInput);
    }
}
