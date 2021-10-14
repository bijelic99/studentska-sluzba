package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.CourseAdditionalPointsTypeDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.CourseAdditionalPointsType;
import com.ftn.studentskasluzba.service.rest.CourseAdditionalPointsTypeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/course-additional-points-type")
public class CourseAdditionalPointsTypeRestController extends RestControllerAbstractClass<CourseAdditionalPointsType, CourseAdditionalPointsTypeDTO> {

    public CourseAdditionalPointsTypeRestController() {

    }

    @Autowired
    public CourseAdditionalPointsTypeRestController(CourseAdditionalPointsTypeRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "name",
                        "name"
                ),
                new CourseAdditionalPointsTypeDTO(
                        null,
                        null,
                        null
                ),
                service
        );
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CourseAdditionalPointsTypeDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<CourseAdditionalPointsTypeDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<CourseAdditionalPointsTypeDTO> post(@RequestBody CourseAdditionalPointsTypeDTO courseAdditionalPointsTypeDTO) {
        return super.post(courseAdditionalPointsTypeDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<CourseAdditionalPointsTypeDTO> put(@RequestBody CourseAdditionalPointsTypeDTO courseAdditionalPointsTypeDTO) {
        return super.put(courseAdditionalPointsTypeDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
