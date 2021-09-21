package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.DocumentTypeDTO;
import com.ftn.studentskasluzba.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/document-type")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping
    public ResponseEntity getAllDocumentTypes() {
        return new ResponseEntity<>(documentTypeService.getAllDocumentTypes().stream().map(DocumentTypeDTO::new), HttpStatus.OK);
    }
}
