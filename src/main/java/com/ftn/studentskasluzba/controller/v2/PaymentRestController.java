package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.PaymentDTO;
import com.ftn.studentskasluzba.model.Payment;
import com.ftn.studentskasluzba.service.rest.PaymentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/payment")
public class PaymentRestController extends RestControllerAbstractClass<Payment, PaymentDTO> {



    public PaymentRestController() {

    }

    @Autowired
    public PaymentRestController(PaymentRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "timestamp",
                        "timestamp",
                        "amount",
                        "amount"
                ),
                new PaymentDTO(
                        null,
                        null,
                        null,
                        null,
                        null
                ),
                service
        );
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<PaymentDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<PaymentDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<PaymentDTO> post(@RequestBody PaymentDTO paymentDTO) {
        return super.post(paymentDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<PaymentDTO> put(@RequestBody PaymentDTO paymentDTO) {
        return super.put(paymentDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
