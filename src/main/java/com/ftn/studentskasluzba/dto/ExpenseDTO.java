package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Expense;
import org.joda.time.DateTime;

public record ExpenseDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("studentsAccount")
        StudentsAccountDTO studentsAccount,
        @JsonProperty("timestamp")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime timestamp,
        @JsonProperty("amount")
        Double amount,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<Expense, ExpenseDTO> {
    public ExpenseDTO(Expense expense) {
        this(
                expense.getId(),
                new StudentsAccountDTO(expense.getAccount()),
                expense.getTimestamp(),
                expense.getAmount(),
                expense.getDeleted()
        );
    }

    @Override
    public Expense toModel() {
        return new Expense(
                id,
                timestamp,
                amount,
                studentsAccount.toModel(),
                deleted
        );
    }

    @Override
    public ExpenseDTO fromModel(Expense modelObject) {
        return new ExpenseDTO(modelObject);
    }
}
