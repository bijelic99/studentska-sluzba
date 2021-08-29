package com.ftn.studentskasluzba.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftn.studentskasluzba.dto.StudentsDocumentDTO;
import com.ftn.studentskasluzba.model.StudentsDocument;
import com.ftn.studentskasluzba.repository.StudentsDocumentRepository;
import com.ftn.studentskasluzba.service.StudentsDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/students-document")
public class StudentsDocumentController {

    @Autowired
    StudentsDocumentRepository studentsDocumentRepository;

    @Autowired
    StudentsDocumentService studentsDocumentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentsDocumentDTO> get(@PathVariable("id") Long id) {
        return studentsDocumentRepository
                .findById(id)
                .map(StudentsDocumentDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<StudentsDocumentDTO> put(@RequestParam("studentsDocument") String jsonStudentsDocument, @RequestParam("file")  MultipartFile file) {
        try {
            var om = new ObjectMapper();
            var studentsDocument = om.readValue(jsonStudentsDocument, StudentsDocumentDTO.class);
            StudentsDocument document = studentsDocumentService.saveStudentsDocument(studentsDocument.toModel(), file);
            return ResponseEntity.ok(new StudentsDocumentDTO(document));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return studentsDocumentService.deleteStudentsDocument(id);
    }
}
