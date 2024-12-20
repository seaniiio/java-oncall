package oncall.domain;

import java.util.Objects;
import oncall.constant.ErrorMessage;

public class Employee {

    private static final int MAX_EMPLOYEE_NUMBERS = 5;

    private final String name;

    public Employee(String name) {
        this.name = name;
        validate(name);
    }

    private void validate(String name) {
        if (name.length() > MAX_EMPLOYEE_NUMBERS || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPLOYEE_NAME_LENGTH_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
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
