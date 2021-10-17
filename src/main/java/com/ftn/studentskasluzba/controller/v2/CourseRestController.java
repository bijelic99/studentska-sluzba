package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.CourseDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.Course;
import com.ftn.studentskasluzba.service.rest.CourseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v2/course")
public class CourseRestController extends RestControllerAbstractClass<Course, CourseDTO> {


    public CourseRestController() {

    }

    @Autowired
    public CourseRestController(CourseRestService service) {
        super(
                Map.of("id", "id", "endDate", "endDate", "startDate", "startDate", "subject", "subject.title"),
                new CourseDTO(null, null, null, null, null),
                service
        );
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CourseDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<CourseDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<CourseDTO> post(@RequestBody CourseDTO courseDTO) {
        return super.post(courseDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<CourseDTO> put(@RequestBody CourseDTO courseDTO) {
        return super.put(courseDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
