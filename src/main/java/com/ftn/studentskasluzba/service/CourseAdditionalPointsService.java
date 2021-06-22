package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.CourseAdditionalPoints;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAdditionalPointsService {

    @Autowired
    CourseAdditionalPointsRepository courseAdditionalPointsRepository;

    public CourseAdditionalPoints saveCourseAdditionalPoints(CourseAdditionalPoints courseAdditionalPoints) {
        var cAddPtsToSave = courseAdditionalPoints.getId() == null ? courseAdditionalPoints : courseAdditionalPointsRepository.findById(courseAdditionalPoints.getId()).map(exsisting -> {
            courseAdditionalPoints.setCourseAdditionalPointsEnrolments(exsisting.getCourseAdditionalPointsEnrolments());
            return courseAdditionalPoints;
        }).orElseThrow();

        return courseAdditionalPointsRepository.save(cAddPtsToSave);
    }
}
