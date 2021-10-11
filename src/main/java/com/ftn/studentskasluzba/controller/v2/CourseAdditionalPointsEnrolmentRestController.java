package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.CourseAdditionalPointsEnrolmentDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.CourseAdditionalPointsEnrolment;
import com.ftn.studentskasluzba.service.rest.CourseAdditionalPointsEnrolmentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/courseAdditionalPointsEnrolment")
public class CourseAdditionalPointsEnrolmentRestController extends RestControllerAbstractClass<CourseAdditionalPointsEnrolment, CourseAdditionalPointsEnrolmentDTO> {

    public CourseAdditionalPointsEnrolmentRestController() {

    }

    @Autowired
    public CourseAdditionalPointsEnrolmentRestController(CourseAdditionalPointsEnrolmentRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "courseAdditionalPoints",
                        "courseAdditionalPoints.name",
                        "student",
                        "courseEnrolment.student.userGeneralData.username",
                        "points",
                        "points",
                        "passed",
                        "passed"
                ),
                new CourseAdditionalPointsEnrolmentDTO(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                ),
                service
        );
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CourseAdditionalPointsEnrolmentDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<CourseAdditionalPointsEnrolmentDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<CourseAdditionalPointsEnrolmentDTO> post(@RequestBody CourseAdditionalPointsEnrolmentDTO courseAdditionalPointsEnrolmentDTO) {
        return super.post(courseAdditionalPointsEnrolmentDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<CourseAdditionalPointsEnrolmentDTO> put(@RequestBody CourseAdditionalPointsEnrolmentDTO courseAdditionalPointsEnrolmentDTO) {
        return super.put(courseAdditionalPointsEnrolmentDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
