package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Transaction extends BaseAbstractClass {
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime timestamp;
    protected Double amount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    protected StudentsAccount account;
}
