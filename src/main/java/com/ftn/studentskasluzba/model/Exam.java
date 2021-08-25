package com.ftn.studentskasluzba.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Exam extends BaseAbstractClass {
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime examDateTime;
    private Double examEnrolmentFee;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "exam")
    private Set<ExamEnrolment> examEnrolments = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "exam_period_id")
    private ExamPeriod examPeriod;

    public Exam(Long id, DateTime examDateTime, Double examEnrolmentFee, Course course, Set<ExamEnrolment> examEnrolments, ExamPeriod examPeriod) {
        super(id);
        this.examDateTime = examDateTime;
        this.examEnrolmentFee = examEnrolmentFee;
        this.course = course;
        this.examEnrolments = examEnrolments;
        this.examPeriod = examPeriod;
    }
}
