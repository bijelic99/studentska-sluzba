package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.ExamEnrolment;
import com.ftn.studentskasluzba.model.Expense;
import com.ftn.studentskasluzba.repository.CourseEnrolmentRepository;
import com.ftn.studentskasluzba.repository.ExamEnrolmentRepository;
import com.ftn.studentskasluzba.repository.ExamRepository;
import com.ftn.studentskasluzba.repository.ExpenseRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamEnrolmentRestService extends RestServiceAbstractClass<ExamEnrolment> {

    @Autowired
    public ExamEnrolmentRestService(ExamEnrolmentRepository repository) {
        super(repository, new ExamEnrolment());
    }

    @Autowired
    public ExpenseRepository expenseRepository;

    @Autowired
    public ExamRepository examRepository;

    @Autowired
    public CourseEnrolmentRepository courseEnrolmentRepository;

    @Override
    public ExamEnrolment applyPostChangesToEntity(ExamEnrolment examEnrolment) {
        examEnrolment.setId(null);
        examEnrolment.setDeleted(false);

        var courseEnrolment = courseEnrolmentRepository.findById(examEnrolment.getCourseEnrolment().getId()).get();
        var exam = examRepository.findById(examEnrolment.getExam().getId()).get();
        var expense = new Expense(null, DateTime.now(), exam.getExamEnrolmentFee(), courseEnrolment.getStudent().getStudentsAccount(), false);
        expense =expenseRepository.save(expense);

        examEnrolment.setExpense(expense);

        return repository.save(examEnrolment);
    }

    @Override
    protected ExamEnrolment applyPutChangesToEntity(ExamEnrolment originalEntity, ExamEnrolment changedEntity) {
        changedEntity = super.applyPutChangesToEntity(originalEntity, changedEntity);
        var exam = examRepository.findById(originalEntity.getExam().getId()).get();
        var expense = expenseRepository.findById(originalEntity.getExpense().getId()).get();
        expense.setAmount(exam.getExamEnrolmentFee());
        expense = expenseRepository.save(expense);
        changedEntity.setExpense(expense);

        return changedEntity;
    }
}
