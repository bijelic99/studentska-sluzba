package com.ftn.studentskasluzba.model;

public enum Role {
    ADMIN, EMPLOYEE, STUDENT;

    public static Role getRole(ApplicationUser applicationUser) throws Exception {
        if (applicationUser instanceof Student) return STUDENT;
        else if (applicationUser instanceof Employee) return EMPLOYEE;
        else if(applicationUser instanceof Admin) return ADMIN;
        else throw new Exception("Cannot determine role");
    }
}
