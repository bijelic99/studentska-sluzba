package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.CourseEnrolment;
import com.ftn.studentskasluzba.repository.CourseEnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseEnrolmentRestService extends RestServiceAbstractClass<CourseEnrolment> {

    @Autowired
    public CourseEnrolmentRestService(CourseEnrolmentRepository repository) {
        super(repository, new CourseEnrolment());
    }

    @Override
    protected CourseEnrolment applyPutChangesToEntity(CourseEnrolment originalEntity, CourseEnrolment changedEntity) {
        originalEntity.setStudent(changedEntity.getStudent());
        originalEntity.setCourse(changedEntity.getCourse());
        return originalEntity;
    }

}
