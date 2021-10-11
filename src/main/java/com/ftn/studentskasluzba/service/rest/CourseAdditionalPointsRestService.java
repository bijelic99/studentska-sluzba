package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.CourseAdditionalPoints;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAdditionalPointsRestService extends RestServiceAbstractClass<CourseAdditionalPoints> {

    @Autowired
    public CourseAdditionalPointsRestService(CourseAdditionalPointsRepository repository) {
        super(repository, new CourseAdditionalPoints());
    }

    @Override
    protected CourseAdditionalPoints applyPutChangesToEntity(CourseAdditionalPoints originalEntity, CourseAdditionalPoints changedEntity) {
        originalEntity.setName(changedEntity.getName());
        originalEntity.setPassRequired(changedEntity.getPassRequired());
        originalEntity.setStartDatetime(changedEntity.getStartDatetime());
        originalEntity.setEndDatetime(changedEntity.getEndDatetime());
        originalEntity.setCourse(changedEntity.getCourse());
        originalEntity.setCourseAdditionalPointsType(changedEntity.getCourseAdditionalPointsType());

        return originalEntity;
    }
}
