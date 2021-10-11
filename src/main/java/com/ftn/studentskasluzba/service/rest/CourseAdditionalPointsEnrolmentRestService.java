package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.CourseAdditionalPointsEnrolment;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsEnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAdditionalPointsEnrolmentRestService extends RestServiceAbstractClass<CourseAdditionalPointsEnrolment> {

    @Autowired
    public CourseAdditionalPointsEnrolmentRestService(CourseAdditionalPointsEnrolmentRepository repository) {
        super(repository, new CourseAdditionalPointsEnrolment());
    }

    @Override
    protected CourseAdditionalPointsEnrolment applyPutChangesToEntity(CourseAdditionalPointsEnrolment originalEntity, CourseAdditionalPointsEnrolment changedEntity) {

        originalEntity.setCourseAdditionalPoints(changedEntity.getCourseAdditionalPoints());
        originalEntity.setCourseEnrolment(changedEntity.getCourseEnrolment());
        originalEntity.setPoints(changedEntity.getPoints());
        originalEntity.setPassed(changedEntity.getPassed());

        return originalEntity;
    }
}
