package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Payment;
import org.joda.time.DateTime;

public record PaymentDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("timestamp")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime timestamp,
        @JsonProperty("amount")
        Double amount,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<Payment, PaymentDTO> {
    public PaymentDTO(Payment payment) {
        this(
                payment.getId(),
                payment.getTimestamp(),
                payment.getAmount(),
                payment.getDeleted()
        );
    }

    @Override
    public Payment toModel() {
        return new Payment(
                id,
                timestamp,
                amount,
                deleted
        );
    }

    @Override
    public PaymentDTO fromModel(Payment modelObject) {
        return new PaymentDTO(modelObject);
    }
}
