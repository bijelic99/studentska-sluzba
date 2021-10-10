package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Employee;
import com.ftn.studentskasluzba.model.Role;
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
        String lastName,
        @JsonProperty("role")
        Role role,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToModel<Employee>, UserWithRole {
    public EmployeeDTO(Employee employee) {
        this(
                employee.getId(),
                employee.getUserGeneralData().getEmail(),
                employee.getUserGeneralData().getUsername(),
                employee.getUserGeneralData().getFirstName(),
                employee.getUserGeneralData().getLastName(),
                Role.EMPLOYEE,
                employee.getDeleted()
        );
    }

    @Override
    public Employee toModel() {
        return new Employee(id, new UserGeneralData(email, username, null, firstName, lastName), new HashSet<>(), deleted);
    }
}
