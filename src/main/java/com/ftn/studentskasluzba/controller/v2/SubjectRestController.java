package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.SubjectDTO;
import com.ftn.studentskasluzba.model.Subject;
import com.ftn.studentskasluzba.service.rest.SubjectRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/subject")
public class SubjectRestController extends RestControllerAbstractClass<Subject, SubjectDTO> {

    public SubjectRestController() {

    }

    @Autowired
    public SubjectRestController(SubjectRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "title",
                        "title",
                        "ects",
                        "ECTS"
                ),
                new SubjectDTO(
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
    public ResponseEntity<SubjectDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<SubjectDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<SubjectDTO> post(@RequestBody SubjectDTO subjectDTO) {
        return super.post(subjectDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<SubjectDTO> put(@RequestBody SubjectDTO subjectDTO) {
        return super.put(subjectDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
