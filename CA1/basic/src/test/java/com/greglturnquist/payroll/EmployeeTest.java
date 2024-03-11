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
        employee = new Employee("Bilbo", "Baggins", "ring bearer",  3, "burglar");
    }
    @Test
    void testEmployee() {
        assert employee.validateArguments("Bilbo", "Baggins", "ring bearer",  3, "burglar");
    }
    @Test
    void validateArguments() {
        assert employee.validateArguments("Bilbo", "Baggins", "ring bearer",  3,"burglar");
    }
    @Test
    void testEquals() {
        Employee employee2 = new Employee("Bilbo", "Baggins", "ring bearer", 3,"burglar");
        assert employee.equals(employee2);
    }
    @Test
    void testHashCode() {
        Employee employee2 = new Employee("Bilbo", "Baggins", "ring bearer", 3,"burglar");
        assert Objects.equals(employee.hashCode(), employee2.hashCode());
    }
    @Test
    void EmployeeTest2() {
        assert employee.getId() == null;
    }
    @Test
    void testToString() {
        Employee employee = new Employee("Bilbo", "Baggins", "ring bearer", 3, "burglar");
        String result = employee.toString();
        String expected = "Employee{id=null, firstName='Bilbo', lastName='Baggins', description='ring bearer', jobYears=3', jobTitle=burglar}";
        assertEquals(expected, result);
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
                void constructorException() {
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Employee(null, "Baggins", "ring bearer",  3,"burglar");
                    });
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Employee("Bilbo", null, "ring bearer",  3,"burglar");
                    });
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Employee("Bilbo", "Baggins", null,  3,"burglar");
                    });
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Employee("Bilbo", "Baggins", "ring bearer",  -1,"burglar");
                    });
                    assertThrows(IllegalArgumentException.class, () -> {
                        new Employee("Bilbo", "Baggins", "ring bearer",  3,null);
                    });
                }
            }