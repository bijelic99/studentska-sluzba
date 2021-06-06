package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Employee;
import com.ftn.studentskasluzba.model.UserGeneralData;

import java.util.HashSet;

public record EmployeeDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("email")
        String email,
        @JsonProperty("username")
        String username,
        @JsonProperty("firstName")
        String firstName,
        @JsonProperty("lastName")
        String lastName
) implements ToModel<Employee> {
    public EmployeeDTO(Employee employee) {
        this(
                employee.getId(),
                employee.getUserGeneralData().getEmail(),
                employee.getUserGeneralData().getUsername(),
                employee.getUserGeneralData().getFirstName(),
                employee.getUserGeneralData().getLastName()
        );
    }

    @Override
    public Employee toModel() {
        return new Employee(id, new UserGeneralData(email, username, null, firstName, lastName), new HashSet<>());
    }
}
