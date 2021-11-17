package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.DocumentType;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.model.StudentsDocument;
import com.ftn.studentskasluzba.repository.DocumentTypeRepository;
import com.ftn.studentskasluzba.repository.StudentRepository;
import com.ftn.studentskasluzba.repository.StudentsDocumentRepository;
import com.ftn.studentskasluzba.service.S3Client;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class StudentsDocumentRestService extends RestServiceAbstractClass<StudentsDocument> {

    @Autowired
    public StudentsDocumentRestService(StudentsDocumentRepository repository) {
        super(repository, new StudentsDocument());
    }

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    S3Client s3Client;

    public StudentsDocument postStudentsDocument(MultipartFile file, Long documentTypeId, Long studentId) throws Exception {

        var studentsDocument = new StudentsDocument();

        var documentExtension = resolveExtension(file.getContentType());
        var possibleDocumentPath = constructStudentsDocumentPath(studentId, documentExtension);

        var finalDocumentPath = s3Client.putFile(possibleDocumentPath, file.getInputStream(), file.getContentType(), file.getSize());

        Student student = studentRepository.findById(studentId).orElseThrow();

        DocumentType documentType = documentTypeRepository.findById(documentTypeId).orElseThrow();

        studentsDocument.setDocumentType(documentType);
        studentsDocument.setStudent(student);
        studentsDocument.setUrl(finalDocumentPath);

        return repository.save(studentsDocument);
    }

    public StudentsDocument putStudentsDocument(Long id, MultipartFile file, Long documentTypeId, Long studentId) throws Exception {

        var studentsDocument = repository.findById(id).orElseThrow();

        s3Client.deleteFile(studentsDocument.getUrl());

        var documentExtension = resolveExtension(file.getContentType());
        var possibleDocumentPath = constructStudentsDocumentPath(studentId, documentExtension);
        var finalDocumentPath = s3Client.putFile(possibleDocumentPath, file.getInputStream(), file.getContentType(), file.getSize());

        Student student = studentRepository.findById(studentId).orElseThrow();

        DocumentType documentType = documentTypeRepository.findById(documentTypeId).orElseThrow();

        studentsDocument.setDocumentType(documentType);
        studentsDocument.setStudent(student);
        studentsDocument.setUrl(finalDocumentPath);

        return repository.save(studentsDocument);
    }

    private String resolveExtension(String mimeType) throws MimeTypeException {
        var allTypes = MimeTypes.getDefaultMimeTypes();
        var thisMimeType = allTypes.forName(mimeType);
        return thisMimeType.getExtension();
    }

    private String constructStudentsDocumentPath(Long studentId, String extension) {
        return String.format("%s/%s%s", studentId, UUID.randomUUID(), extension);
    }

}
