package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.TeacherDTO;
import com.ftn.studentskasluzba.model.Teacher;
import com.ftn.studentskasluzba.service.rest.TeacherRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/teacher")
public class TeacherRestController extends RestControllerAbstractClass<Teacher, TeacherDTO> {

    public TeacherRestController() {

    }

    @Autowired
    public TeacherRestController(TeacherRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "course",
                        "course.subject.title",
                        "employee",
                        "employee.userGeneralData.username",
                        "teachingRole",
                        "teachingRole.name"
                ),
                new TeacherDTO(
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
    public ResponseEntity<TeacherDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<TeacherDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<TeacherDTO> post(@RequestBody TeacherDTO teacherDTO) {
        return super.post(teacherDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<TeacherDTO> put(@RequestBody TeacherDTO teacherDTO) {
        return super.put(teacherDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
