package com.ftn.studentskasluzba.controller;

import com.ftn.studentskasluzba.dto.*;
import com.ftn.studentskasluzba.model.CourseEnrolment;
import com.ftn.studentskasluzba.model.Expense;
import com.ftn.studentskasluzba.model.Payment;
import com.ftn.studentskasluzba.model.Student;
import com.ftn.studentskasluzba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping( value = "/{id}")
    public ResponseEntity getStudent(@PathVariable("id") Long id) {
        Student s = studentService.getStudent(id);
        if(s != null)
            return new ResponseEntity<>(new StudentDTO(s), HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{id}/courses/{courseId}/enrolments")
    public ResponseEntity enrollCourse(@PathVariable("id") Long id, @PathVariable("courseId") Long courseId) {
        CourseEnrolment ce = studentService.enroll(id, courseId);
        if(ce != null)
            return new ResponseEntity<>(HttpStatus.CREATED);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity getCourses(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentCourses(id).stream()
                .map(CourseDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @GetMapping("/{id}/documents")
    public ResponseEntity getStudentDocuments(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentDocuments(id).stream()
                .map(StudentDocumentDTO::new) ,HttpStatus.OK);
    }

    @GetMapping("/{id}/exams")
    public ResponseEntity getExams(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getExams(id).stream()
                .map(ExamDTO::new).collect(Collectors.toSet()) ,HttpStatus.OK);
    }

    @GetMapping("/{id}/colloquiums")
    public ResponseEntity getColloquiums(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getColloquiums(id).stream()
                .map(CourseAdditionalPointsEnrolmentDTO::new) ,HttpStatus.OK);
    }

    @GetMapping("/{id}/payments")
    public ResponseEntity getPayments(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentPayments(id).stream()
                .map(PaymentDTO::new).collect(Collectors.toSet()) ,HttpStatus.OK);
    }

    @PostMapping("/{id}/payments")
    public ResponseEntity createPayment(@PathVariable("id") Long id,@RequestBody PaymentDTO paymentDTO) {
        Payment p = studentService.createPayment(id, paymentDTO.toModel());
        if(p != null)
            return new ResponseEntity<>(new PaymentDTO(p), HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}/expenses")
    public ResponseEntity getExpenses(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentExpenses(id).stream()
                .map(ExpenseDTO::new).collect(Collectors.toSet()) ,HttpStatus.OK);
    }

    @PostMapping("/{id}/expenses")
    public ResponseEntity createExpenses(@PathVariable("id") Long id,@RequestBody ExpenseDTO expenseDTO) {
        Expense e = studentService.createExpense(id, expenseDTO.toModel());
        if(e != null)
            return new ResponseEntity(new ExpenseDTO(e), HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
