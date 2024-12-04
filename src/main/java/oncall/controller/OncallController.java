package oncall.controller;

import java.util.List;
import oncall.dto.EmergencyTable;
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
        InputProcessor.continueUntilNormalInput(this::processStartingPointInput, outputView::printErrorMessage);
        InputProcessor.continueUntilNormalInput(this::processSequenceInput, outputView::printErrorMessage);

        List<EmergencyTable> emergencyTables = oncallService.assignTable();
        outputView.printEmergencyTable(emergencyTables);
    }

    private void processSequenceInput() {
        InputProcessor.continueUntilNormalInput(this::processWeekdaySequenceInput, outputView::printErrorMessage);
        processHolidaySequenceInput();
    }

    private void processHolidaySequenceInput() {
        String holidaySequenceInput = inputView.holidaySequenceInput();
        oncallService.setHolidaySequence(holidaySequenceInput);
    }

    private void processWeekdaySequenceInput() {
        String weekdaySequenceInput = inputView.weekdaySequenceInput();
        oncallService.setWeekdaySequence(weekdaySequenceInput);
    }

    private void processStartingPointInput() {
        String startingPointInput = inputView.startingPointInput();
        oncallService.setStartingPoint(startingPointInput);
    }
}
