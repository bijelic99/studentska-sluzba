package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Payment;
import org.joda.time.DateTime;

public record PaymentDTO(
        @JsonProperty
        Long id,
        @JsonProperty
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime timestamp,
        @JsonProperty
        Double amount,
        @JsonProperty
        StudentsAccountDTO studentsAccount
) implements ToModel<Payment> {
    public PaymentDTO(Payment payment) {
        this(
                payment.getId(),
                payment.getTimestamp(),
                payment.getAmount(),
                new StudentsAccountDTO(payment.getAccount())
        );
    }

    @Override
    public Payment toModel() {
        return new Payment(
                id,
                timestamp,
                amount,
                studentsAccount.toModel()
        );
    }
}
