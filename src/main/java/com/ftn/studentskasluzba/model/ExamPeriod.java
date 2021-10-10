package com.ftn.studentskasluzba.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExamPeriod extends BaseAbstractClass {
    private String name;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endTime;
    @OneToMany(mappedBy = "examPeriod")
    private Set<Exam> exams;

    public ExamPeriod(Long id, String name, DateTime startTime, DateTime endTime, Set<Exam> exams, Boolean deleted) {
        super(id, deleted);
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.exams = exams;
    }
}
