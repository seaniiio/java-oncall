package oncall.view;

import java.util.List;
import oncall.dto.EmergencyTableDto;

public class OutputView {
    public void printEmergencyTable(List<EmergencyTableDto> emergencyTables) {
        for (EmergencyTableDto emergencyTable : emergencyTables) {
            System.out.println(emergencyTable);
        }
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
