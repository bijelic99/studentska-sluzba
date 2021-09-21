package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.DocumentType;
import com.ftn.studentskasluzba.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public Set<DocumentType> getAllDocumentTypes() {
        return new HashSet<>(documentTypeRepository.findAll());
    }
}
