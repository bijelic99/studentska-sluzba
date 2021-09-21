package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.DocumentType;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.StudentsDocument;
import com.ftn.studentskasluzba.repository.DocumentTypeRepository;
import com.ftn.studentskasluzba.repository.StudentRepository;
import com.ftn.studentskasluzba.repository.StudentsDocumentRepository;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class StudentsDocumentService {

    @Autowired
    private StudentsDocumentRepository studentsDocumentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    S3Client s3Client;

    public StudentsDocument saveStudentsDocument(Long id, StudentsDocument studentsDocument, MultipartFile file, Long documentTypeId) throws Exception {

        var documentExtension = resolveExtension(file.getContentType());
        var possibleDocumentPath = constructStudentsDocumentPath(id, documentExtension);
        Student student = studentRepository.getOne(id);

        if (studentsDocument.getId() == null) {
            var finalDocumentPath = s3Client.putFile(possibleDocumentPath, file.getInputStream(), file.getContentType(), file.getSize());

            DocumentType documentType = documentTypeRepository.getOne(documentTypeId);

            studentsDocument.setDocumentType(documentType);
            studentsDocument.setStudent(student);
            studentsDocument.setUrl(finalDocumentPath);

            return studentsDocumentRepository.save(studentsDocument);
        } else {
            var existingDoc = studentsDocumentRepository.findById(studentsDocument.getId()).orElseThrow();
            if (s3Client.deleteFile(existingDoc.getUrl())) {
                var finalDocumentPath = s3Client.putFile(possibleDocumentPath, file.getInputStream(), file.getContentType(), file.getSize());
                existingDoc.setUrl(finalDocumentPath);
                existingDoc.setDocumentType(studentsDocument.getDocumentType());
                return studentsDocumentRepository.save(existingDoc);
            } else throw new Exception("Couldn't delete the file");
        }
    }

    private String resolveExtension(String mimeType) throws MimeTypeException {
        var allTypes = MimeTypes.getDefaultMimeTypes();
        var thisMimeType = allTypes.forName(mimeType);
        return thisMimeType.getExtension();
    }

    private String constructStudentsDocumentPath(Long studentId, String extension) {
        return String.format("%s/%s%s", studentId, UUID.randomUUID(), extension);
    }

    public Boolean deleteStudentsDocument(Long id) {
        try {
            var document = studentsDocumentRepository.findById(id).orElseThrow();
            s3Client.deleteFile(document.getUrl());
            studentsDocumentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
