package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Payment;
import com.ftn.studentskasluzba.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentRestService extends RestServiceAbstractClass<Payment> {

    @Autowired
    public PaymentRestService(PaymentRepository repository) {
        super(repository, new Payment());
    }

}
