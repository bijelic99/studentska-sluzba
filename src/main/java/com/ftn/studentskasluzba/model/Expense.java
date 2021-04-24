package com.ftn.studentskasluzba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
public class Expense extends Transaction {

}
