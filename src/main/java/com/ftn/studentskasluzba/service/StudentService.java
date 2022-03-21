package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.*;
import com.ftn.studentskasluzba.repository.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamEnrolmentRepository examEnrolmentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private CourseEnrolmentRepository courseEnrolmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentsAccountRepository accountRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public CourseEnrolment enroll(Long id, Long courseId) {
        Course c = courseRepository.getOne(courseId);
        Student s = studentRepository.getOne(id);
        if (!s.getCourseEnrolments().stream().map(CourseEnrolment::getCourse).collect(Collectors.toList()).contains(c)) {
            CourseEnrolment courseEnrolment = new CourseEnrolment(s, c);
            courseEnrolmentRepository.save(courseEnrolment);
            return courseEnrolment;
        }
        return null;
    }

    public Set<Course> getStudentCourses(Long id) {
        return studentRepository.getOne(id).getCourseEnrolments().stream()
                .map(CourseEnrolment::getCourse).collect(Collectors.toSet());
    }

    public Set<StudentsDocument> getStudentDocuments(Long id) {
        return new HashSet<>(studentRepository.getOne(id).getStudentsDocuments());
    }

    public Set<Exam> getExams(Long id) {
        Student student = studentRepository.getOne(id);
        return examEnrolmentRepository.findAll().stream().filter(examEnrolment -> examEnrolment.getCourseEnrolment()
                .getStudent().equals(student)).map(ExamEnrolment::getExam).collect(Collectors.toSet());
    }

    public ExamEnrolment examEnroll(Long id, Long examId) {
        Exam exam = examRepository.getOne(examId);
        Student student = studentRepository.getOne(id);
        Optional<CourseEnrolment> possibleCourseEnrolment = student.getCourseEnrolments().stream()
                .filter(ce -> ce.getCourse().equals(exam.getCourse())).findFirst();

        if (possibleCourseEnrolment.isPresent() && student.getStudentsAccount().getAmount() > exam.getExamEnrolmentFee()) {
            for (ExamEnrolment examEnrolment : possibleCourseEnrolment.get().getExamEnrolments()) {
                if (examEnrolment.getExam().equals(exam))
                    return null;
            }

            Expense newExpense = new Expense();
            newExpense.setAccount(student.getStudentsAccount());
            newExpense.setAmount(exam.getExamEnrolmentFee());
            student.getStudentsAccount().setAmount(student.getStudentsAccount().getAmount() - exam.getExamEnrolmentFee());
            newExpense.setTimestamp(DateTime.now());

            ExamEnrolment newExamEnrolment = new ExamEnrolment();
            newExamEnrolment.setExam(exam);
            newExamEnrolment.setCourseEnrolment(possibleCourseEnrolment.get());
            newExamEnrolment.setExpense(newExpense);

            expenseRepository.save(newExpense);
            examEnrolmentRepository.save(newExamEnrolment);
            accountRepository.save(student.getStudentsAccount());

            return newExamEnrolment;
        }

        return null;
    }

    public Set<Payment> getStudentPayments(Long id) {
        StudentsAccount account = studentRepository.getOne(id).getStudentsAccount();
        if (account != null)
            return new HashSet<>(account.getPayments());
        return new HashSet<>();
    }

    public Payment createPayment(Long id, Payment payment) {
        Student s = studentRepository.getOne(id);
        StudentsAccount account = s.getStudentsAccount();
        if (account != null) {
            account.setAmount(account.getAmount() + payment.getAmount());
            payment.setAccount(account);
            account.getPayments().add(payment);
            paymentRepository.save(payment);
            accountRepository.save(account);
            return payment;
        }

        return null;
    }

    public Set<Expense> getStudentExpenses(Long id) {
        StudentsAccount account = studentRepository.getOne(id).getStudentsAccount();
        if (account != null)
            return new HashSet<>(account.getExpenses());
        return new HashSet<>();
    }

    public Expense createExpense(Long id, Expense expense) {
        Student s = studentRepository.getOne(id);
        StudentsAccount account = s.getStudentsAccount();
        if (account != null) {
            if (account.getAmount() > expense.getAmount()) {
                account.setAmount(account.getAmount() - expense.getAmount());
                expense.setAccount(account);
                account.getExpenses().add(expense);
                expenseRepository.save(expense);
                accountRepository.save(account);
                return expense;
            }
        }

        return null;
    }

    public Set<CourseAdditionalPointsEnrolment> getColloquiums(Long id) {
        Student student = studentRepository.getOne(id);
        return courseEnrolmentRepository.findAll()
                .stream().filter(courseEnrolment -> courseEnrolment.getStudent().equals(student))
                .map(CourseEnrolment::getAdditionalPointsEnrolments).flatMap(Collection::stream).collect(Collectors.toSet());
    }

    public Set<ExamEnrolment> getPassedExams(Long id) {
        return studentRepository
                .getOne(id)
                .getCourseEnrolments()
                .stream()
                .flatMap(courseEnrolment -> courseEnrolment.getExamEnrolments().stream())
                .filter(examEnrolment -> examEnrolment.getGrade() != null && examEnrolment.getGrade() > 5)
                .collect(Collectors.toSet());
    }

}

