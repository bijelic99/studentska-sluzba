package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.StudentsDocumentDTO;
import com.ftn.studentskasluzba.model.StudentsDocument;
import com.ftn.studentskasluzba.repository.StudentsDocumentRepository;
import com.ftn.studentskasluzba.service.StudentsDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<StudentsDocumentDTO> put(@RequestParam("file")  MultipartFile file, @RequestParam("documentTypeId") Long documentTypeId, @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(new StudentsDocumentDTO(studentsDocumentService.saveStudentsDocument(id, new StudentsDocument(), file, documentTypeId)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return studentsDocumentService.deleteStudentsDocument(id);
    }
}
