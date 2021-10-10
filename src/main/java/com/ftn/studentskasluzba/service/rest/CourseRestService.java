package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.Course;
import com.ftn.studentskasluzba.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRestService extends RestServiceAbstractClass<Course>{
    @Autowired
    public CourseRestService(CourseRepository repository) {
        super(repository, new Course());
    }

    @Override
    protected Course applyPutChangesToEntity(Course originalEntity, Course changedEntity) {
        originalEntity.setEndDate(changedEntity.getEndDate());
        originalEntity.setStartDate(changedEntity.getStartDate());
        originalEntity.setSubject(changedEntity.getSubject());
        return originalEntity;
    }
}
