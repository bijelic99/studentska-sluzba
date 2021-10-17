package com.ftn.studentskasluzba.controller.v2;


import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.StudentDTO;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.service.rest.StudentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/student")
public class StudentRestController extends RestControllerAbstractClass<Student, StudentDTO> {

    public StudentRestController() {

    }

    @Autowired
    public StudentRestController(StudentRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "email",
                        "userGeneralData.email",
                        "username",
                        "userGeneralData.username",
                        "firstName",
                        "userGeneralData.firstName",
                        "lastName",
                        "userGeneralData.lastName"
                ),
                new StudentDTO(
                        null,
                        null,
                        null,
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
    public ResponseEntity<StudentDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<StudentDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<StudentDTO> post(@RequestBody StudentDTO studentDTO) {
        return super.post(studentDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<StudentDTO> put(@RequestBody StudentDTO studentDTO) {
        return super.put(studentDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
