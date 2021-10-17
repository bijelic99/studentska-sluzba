package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.StudentsAccountDTO;
import com.ftn.studentskasluzba.model.StudentsAccount;
import com.ftn.studentskasluzba.service.rest.StudentsAccountRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/students-account")
public class StudentsAccountRestController extends RestControllerAbstractClass<StudentsAccount, StudentsAccountDTO> {

    public StudentsAccountRestController() {

    }

    @Autowired
    public StudentsAccountRestController(StudentsAccountRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "student",
                        "student.userGeneralData.username",
                        "amount",
                        "amount"
                ),
                new StudentsAccountDTO(
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
    public ResponseEntity<StudentsAccountDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<StudentsAccountDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<StudentsAccountDTO> post(@RequestBody StudentsAccountDTO studentsAccountDTO) {
        return super.post(studentsAccountDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<StudentsAccountDTO> put(@RequestBody StudentsAccountDTO studentsAccountDTO) {
        return super.put(studentsAccountDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
