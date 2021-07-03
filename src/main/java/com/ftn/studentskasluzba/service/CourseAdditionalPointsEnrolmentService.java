package com.ftn.studentskasluzba.service;

import com.ftn.studentskasluzba.model.CourseAdditionalPointsEnrolment;
import com.ftn.studentskasluzba.repository.CourseAdditionalPointsEnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAdditionalPointsEnrolmentService {

    @Autowired
    CourseAdditionalPointsEnrolmentRepository courseAdditionalPointsEnrolmentRepository;

    public CourseAdditionalPointsEnrolment saveEnrolment(CourseAdditionalPointsEnrolment providedEnrolment) {
        var enrToSave = providedEnrolment.getId() == null ? providedEnrolment : courseAdditionalPointsEnrolmentRepository.findById(providedEnrolment.getId()).map(x -> {
            x.setPoints(providedEnrolment.getPoints());
            x.setPassed(providedEnrolment.getPassed());
            return x;
        }).orElseThrow();

        return courseAdditionalPointsEnrolmentRepository.save(enrToSave);
    }
}
