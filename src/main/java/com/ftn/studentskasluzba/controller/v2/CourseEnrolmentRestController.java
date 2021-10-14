package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.CourseEnrolmentDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.CourseEnrolment;
import com.ftn.studentskasluzba.service.rest.CourseEnrolmentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/course-enrolment")
public class CourseEnrolmentRestController extends RestControllerAbstractClass<CourseEnrolment, CourseEnrolmentDTO> {

    public CourseEnrolmentRestController() {

    }

    @Autowired
    public CourseEnrolmentRestController(CourseEnrolmentRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "student",
                        "student.userGeneralData.username",
                        "course",
                        "course.subject.title"
                ),
                new CourseEnrolmentDTO(
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
    public ResponseEntity<CourseEnrolmentDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<CourseEnrolmentDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<CourseEnrolmentDTO> post(@RequestBody CourseEnrolmentDTO courseEnrolmentDTO) {
        return super.post(courseEnrolmentDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<CourseEnrolmentDTO> put(@RequestBody CourseEnrolmentDTO courseEnrolmentDTO) {
        return super.put(courseEnrolmentDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
