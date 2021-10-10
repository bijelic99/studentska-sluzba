package com.ftn.studentskasluzba.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Transaction extends BaseAbstractClass {
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime timestamp;
    protected Double amount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    protected StudentsAccount account;

    public Transaction(Long id, DateTime timestamp, Double amount, StudentsAccount account, Boolean deleted) {
        super(id, deleted);
        this.timestamp = timestamp;
        this.amount = amount;
        this.account = account;
    }

    public Transaction(Long id, DateTime timestamp, Double amount, Boolean deleted) {
        super(id, deleted);
        this.timestamp = timestamp;
        this.amount = amount;
    }
}
