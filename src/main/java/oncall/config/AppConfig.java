package oncall.config;

import oncall.controller.OncallController;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    public OncallController oncallController() {
        return new OncallController(inputView(), outputView(), oncallService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private OncallService oncallService() {
        return new OncallService();
    }
}
