package com.ftn.studentskasluzba.model;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Expense extends Transaction {
}
