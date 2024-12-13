package oncall.view;

import java.util.List;
import oncall.dto.WorkList;

public class OutputView {

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResult(List<WorkList> assign) {
        for (WorkList workList : assign) {
            System.out.println(workList.getMessage());
        }
    }
}
