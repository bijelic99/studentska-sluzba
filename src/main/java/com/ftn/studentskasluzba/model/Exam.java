package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Set;

@Data
@AllArgsConstructor
public class Exam {
    private Long id;
    private DateTime examDateTime;
    private Double examEnrolmentFee;
    private Course course;
    private Set<ExamEnrolment> examEnrolments;
}
