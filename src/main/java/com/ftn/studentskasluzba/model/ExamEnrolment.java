package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@Entity
public class ExamEnrolment extends BaseAbstractClass {
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "course_enrolment_id")
    private CourseEnrolment courseEnrolment;
    @OneToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;
}
