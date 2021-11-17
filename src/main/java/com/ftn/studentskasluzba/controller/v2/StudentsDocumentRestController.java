package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.StudentsDocumentDTO;
import com.ftn.studentskasluzba.model.StudentsDocument;
import com.ftn.studentskasluzba.service.rest.StudentsDocumentRestService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/students-document")
public class StudentsDocumentRestController extends RestControllerAbstractClass<StudentsDocument, StudentsDocumentDTO> {

    StudentsDocumentRestService studentsService;

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
        studentsService = service;
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

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<StudentsDocumentDTO> post(
            @ApiParam(type = "file", required = true, example = "null")
            @RequestParam("file")
            MultipartFile file,
            @ApiParam(type = "number", required = true, example = "0")
            @RequestParam("documentTypeId")
            Long documentTypeId,
            @ApiParam(type = "number", required = true, example = "0")
            @RequestParam("studentId")
            Long studentId
    ) throws Exception {
        return ResponseEntity.ok(new StudentsDocumentDTO(studentsService.postStudentsDocument(file, documentTypeId, studentId)));
    }

    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<StudentsDocumentDTO> put(
            @ApiParam(type = "number", required = true, example = "0")
            @RequestParam("id")
            Long id,
            @ApiParam(type = "file", required = true, example = "null")
            @RequestParam("file")
            MultipartFile file,
            @ApiParam(type = "number", required = true, example = "0")
            @RequestParam("documentTypeId")
            Long documentTypeId,
            @ApiParam(type = "number", required = true, example = "0")
            @RequestParam("studentId")
            Long studentId
    ) throws Exception {
        return ResponseEntity.ok(new StudentsDocumentDTO(studentsService.putStudentsDocument(id, file, documentTypeId, studentId)));
    }

    public ResponseEntity<StudentsDocumentDTO> post(@RequestBody StudentsDocumentDTO studentsDocumentDTO) {
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<StudentsDocumentDTO> put(@RequestBody StudentsDocumentDTO studentsDocumentDTO) {
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
