package com.ftn.studentskasluzba.controller.v2;


import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.DocumentTypeDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.DocumentType;
import com.ftn.studentskasluzba.service.rest.DocumentTypeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/documentType")
public class DocumentTypeRestController extends RestControllerAbstractClass<DocumentType, DocumentTypeDTO> {

    public DocumentTypeRestController() {

    }

    @Autowired
    public DocumentTypeRestController(DocumentTypeRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "name",
                        "name"
                ),
                new DocumentTypeDTO(
                        null,
                        null,
                        null
                ),
                service
        );
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DocumentTypeDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<DocumentTypeDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<DocumentTypeDTO> post(@RequestBody DocumentTypeDTO documentTypeDTO) {
        return super.post(documentTypeDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<DocumentTypeDTO> put(@RequestBody DocumentTypeDTO documentTypeDTO) {
        return super.put(documentTypeDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
