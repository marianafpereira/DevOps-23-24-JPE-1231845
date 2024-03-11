package com.greglturnquist.payroll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {
    private Employee employee;
    @BeforeEach
    public void setUp() {
        employee = new Employee("Bilbo", "Baggins", "burglar",  3);
    }
    @Test
    void testEmployee() {
        assert employee.validateArguments("Bilbo", "Baggins", "burglar",  3);
    }
    @Test
    void validateArguments() {
        assert employee.validateArguments("Bilbo", "Baggins", "burglar",  3);
    }
    @Test
    void testEquals() {
        Employee employee2 = new Employee("Bilbo", "Baggins", "burglar",  3);
        assert employee.equals(employee2);
    }
    @Test
    void testHashCode() {
        Employee employee2 = new Employee("Bilbo", "Baggins", "burglar",  3);
        assert Objects.equals(employee.hashCode(), employee2.hashCode());
    }
    @Test
    void getId() {
        assert employee.getId() == null;
    }
    @Test
    void testToString() {
        String result = employee.toString();
        String expected = "Employee{id=null, firstName='Bilbo', lastName='Baggins', description='burglar', jobYears=3}";
        assert Objects.equals(result, expected);
    }
    @Test
    void getFirstName() {
        assert Objects.equals(employee.getFirstName(), "Bilbo");
    }
    @Test
    public void testGetLastName() {
        assert Objects.equals(employee.getLastName(), "Baggins");
    }
    @Test
    void getDescription() {
        assert Objects.equals(employee.getDescription(), "burglar");
    }
    @Test
    void getJobYears() {
        assert Objects.equals(employee.getJobYears(), 3);
    }
    @Test
    void setId() {
        employee.setId(1L);
        assert employee.getId() == 1L;
    }
    @Test
    void setFirstName() {
        employee.setFirstName("Frodo");
        assert Objects.equals(employee.getFirstName(), "Frodo");
    }
    @Test
    void setLastName() {
        employee.setLastName("Baggins");
        assert Objects.equals(employee.getLastName(), "Baggins");
    }
    @Test
    void setDescription() {
        employee.setDescription("burglar");
        assert Objects.equals(employee.getDescription(), "burglar");
    }
    @Test
    void setJobYears() {
        employee.setJobYears(3);;
        assert Objects.equals(employee.getJobYears(), 3);
    }
    @Test
    void constructorException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("", "Baggins", "burglar",  3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Bilbo", "", "burglar",  3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Bilbo", "Baggins", "",  3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Bilbo", "Baggins", "burglar",  0);
        });
    }
}