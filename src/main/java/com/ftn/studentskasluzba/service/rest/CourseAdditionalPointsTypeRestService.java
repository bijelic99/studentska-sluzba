package com.ftn.studentskasluzba.service.rest;

import com.ftn.studentskasluzba.model.CourseAdditionalPointsType;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAdditionalPointsTypeRestService extends RestServiceAbstractClass<CourseAdditionalPointsType> {

    @Autowired
    public CourseAdditionalPointsTypeRestService(CourseAdditionalPointsTypeRepository repository) {
        super(repository, new CourseAdditionalPointsType());
    }

}
