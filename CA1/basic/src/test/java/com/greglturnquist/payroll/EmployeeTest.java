package com.greglturnquist.payroll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("Bilbo", "Baggins", "ring bearer", 3, "burglar", "bilbobaggins@lordoftherings.com");
    }

    @Test
    void testEmployee() {
        assert employee.validateArguments("Bilbo", "Baggins", "ring bearer", 3, "burglar", "bilbobaggins@lordoftherings.com");
    }

    @Test
    void validateArguments() {
        assert employee.validateArguments("Bilbo", "Baggins", "ring bearer", 3, "burglar", "bilbobaggins@lordoftherings.com");
    }

    @Test
    void testEquals() {
        Employee employee2 = new Employee("Bilbo", "Baggins", "ring bearer", 3, "burglar", "bilbobaggins@lordoftherings.com");
        assert employee.equals(employee2);
    }

    @Test
    void testHashCode() {
        Employee employee2 = new Employee("Bilbo", "Baggins", "ring bearer", 3, "burglar", "bilbobaggins@lordoftherings.com");
        assert Objects.equals(employee.hashCode(), employee2.hashCode());
    }

    @Test
    void EmployeeTest2() {
        assert employee.getId() == null;
    }

    @Test
    void testToString() {
        String result = employee.toString();
        String expected = "Employee{id=null, firstName='Bilbo', lastName='Baggins', description='ring bearer', jobYears=3', jobTitle='burglar', email='bilbobaggins@lordoftherings.com'}";
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void getDescription() {
        assert Objects.equals(employee.getDescription(), "ring bearer");
    }

    @Test
    void getJobYears() {
        assert Objects.equals(employee.getJobYears(), 3);
    }

    @Test
    void setDescription() {
        employee.setDescription("ring bearer");
        assert Objects.equals(employee.getDescription(), "ring bearer");
    }

    @Test
    void setJobYears() {
        employee.setJobYears(3);
    }

    @Test
    void setJobTitle() {
        employee.setJobTitle("burglar");
        assert Objects.equals(employee.getJobTitle(), "burglar");
    }

    @Test
    void getJobTitle() {
        assert Objects.equals(employee.getJobTitle(), "burglar");
    }

    @Test
    void getEmail() {
        assert Objects.equals(employee.getEmail(), "bilbobaggins@lordoftherings.com");
    }

    @Test
    void setEmail() {
        employee.setEmail("bilbobaggins@lordoftherings.com");
    }

    @Test
    void constructorException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee(null, "Baggins", "ring bearer", 3, "burglar", "bilbobaggins@lordoftherings.com");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Bilbo", null, "ring bearer", 3, "burglar", "bilbobaggins@lordoftherings.com");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Bilbo", "Baggins", null, 3, "burglar", "bilbobaggins@lordoftherings.com");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Bilbo", "Baggins", "ring bearer", 3, null, "bilbobaggins@lordoftherings.com");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Bilbo", "Baggins", "ring bearer", 3, "burglar", null);
        });
    }
}