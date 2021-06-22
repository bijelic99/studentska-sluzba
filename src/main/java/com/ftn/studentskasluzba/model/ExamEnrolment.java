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
    private Integer grade = null;
    private Integer points = null;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "course_enrolment_id")
    private CourseEnrolment courseEnrolment;
    @OneToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    public ExamEnrolment(Long id, Integer grade, Integer points, Exam exam, CourseEnrolment courseEnrolment, Expense expense) {
        super(id);
        this.grade = grade;
        this.points = points;
        this.exam = exam;
        this.courseEnrolment = courseEnrolment;
        this.expense = expense;
    }
}
