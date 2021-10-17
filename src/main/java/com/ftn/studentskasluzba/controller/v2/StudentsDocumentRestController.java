package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.StudentsDocumentDTO;
import com.ftn.studentskasluzba.model.StudentsDocument;
import com.ftn.studentskasluzba.service.rest.StudentsDocumentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/students-document")
public class StudentsDocumentRestController extends RestControllerAbstractClass<StudentsDocument, StudentsDocumentDTO> {

    public StudentsDocumentRestController() {

    }

    @Autowired
    public StudentsDocumentRestController(StudentsDocumentRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "student",
                        "student.userGeneralData.username",
                        "url",
                        "url",
                        "documentType",
                        "documentType.name"
                ),
                new StudentsDocumentDTO(
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
    public ResponseEntity<StudentsDocumentDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<StudentsDocumentDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<StudentsDocumentDTO> post(@RequestBody StudentsDocumentDTO studentsDocumentDTO) {
        return super.post(studentsDocumentDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<StudentsDocumentDTO> put(@RequestBody StudentsDocumentDTO studentsDocumentDTO) {
        return super.put(studentsDocumentDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
