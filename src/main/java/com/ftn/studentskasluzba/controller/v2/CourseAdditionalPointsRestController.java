package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.CourseAdditionalPointsDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.CourseAdditionalPoints;
import com.ftn.studentskasluzba.service.rest.CourseAdditionalPointsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/course-additional-points")
public class CourseAdditionalPointsRestController extends RestControllerAbstractClass<CourseAdditionalPoints, CourseAdditionalPointsDTO> {

    public CourseAdditionalPointsRestController() {

    }

    @Autowired
    public CourseAdditionalPointsRestController(CourseAdditionalPointsRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "name",
                        "name",
                        "passRequired",
                        "passRequired",
                        "startDatetime",
                        "startDatetime",
                        "endDatetime",
                        "endDatetime",
                        "course",
                        "course.subject.title",
                        "courseAdditionalPointsType",
                        "courseAdditionalPointsType.name"
                ),
                new CourseAdditionalPointsDTO(
                        null,
                        null,
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
    public ResponseEntity<CourseAdditionalPointsDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<CourseAdditionalPointsDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<CourseAdditionalPointsDTO> post(@RequestBody CourseAdditionalPointsDTO courseAdditionalPointsDTO) {
        return super.post(courseAdditionalPointsDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<CourseAdditionalPointsDTO> put(@RequestBody CourseAdditionalPointsDTO courseAdditionalPointsDTO) {
        return super.put(courseAdditionalPointsDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
