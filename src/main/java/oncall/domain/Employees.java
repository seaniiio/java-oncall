package oncall.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.constant.ErrorMessage;

public class Employees {

    private List<Employee> employees;

    public Employees(List<String> employeeNames) {
        this.employees = new ArrayList<>();
        validateDuplicate(employeeNames);
        validateNumbers(employeeNames);
        for (String employeeName : employeeNames) {
            employees.add(new Employee(employeeName));
        }
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    private void validateDuplicate(List<String> employeeNames) {
        Set<String> employeesWithoutDuplicate = new HashSet<>(employeeNames);
        if (employeesWithoutDuplicate.size() != employeeNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_NAME_DUPLICATED_ERROR.getMessage());
        }
    }

    private void validateNumbers(List<String> employeeNames) {
        if (employeeNames.size() < 5 || employeeNames.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEES_NUMBER_ERROR.getMessage());
        }
    }
}