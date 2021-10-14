package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.ExpenseDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.Expense;
import com.ftn.studentskasluzba.service.rest.ExpenseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/expense")
public class ExpenseRestController extends RestControllerAbstractClass<Expense, ExpenseDTO> {



    public ExpenseRestController() {

    }

    @Autowired
    public ExpenseRestController(ExpenseRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "timestamp",
                        "timestamp",
                        "amount",
                        "amount"
                ),
                new ExpenseDTO(
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
    public ResponseEntity<ExpenseDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<ExpenseDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<ExpenseDTO> post(@RequestBody ExpenseDTO expenseDTO) {
        return super.post(expenseDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<ExpenseDTO> put(@RequestBody ExpenseDTO expenseDTO) {
        return super.put(expenseDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
