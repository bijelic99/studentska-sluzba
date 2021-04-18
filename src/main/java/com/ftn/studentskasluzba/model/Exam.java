package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exam {
    private Long id;
    private Course course;
    private String examDateTime;
    private Double examEnrolmentFee;
}
