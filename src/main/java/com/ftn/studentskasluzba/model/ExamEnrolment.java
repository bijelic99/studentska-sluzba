package com.ftn.studentskasluzba.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
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

    public ExamEnrolment(Long id, Exam exam, CourseEnrolment courseEnrolment, Expense expense) {
        super(id);
        this.exam = exam;
        this.courseEnrolment = courseEnrolment;
        this.expense = expense;
    }
}
