package oncall.view;

import java.util.List;
import oncall.dto.EmergencyTable;

public class OutputView {
    public void printEmergencyTable(List<EmergencyTable> emergencyTables) {
        for (EmergencyTable emergencyTable : emergencyTables) {
            System.out.println(emergencyTable);
        }
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
