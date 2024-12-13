package oncall.domain;

import java.util.Objects;
import oncall.constant.ErrorMessage;

public class Employee {

    private final String name;

    public Employee(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_NAME_ERROR.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
