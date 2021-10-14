package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.ExamEnrolmentDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.ExamEnrolment;
import com.ftn.studentskasluzba.service.rest.ExamEnrolmentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/exam-enrolment")
public class ExamEnrolmentRestController extends RestControllerAbstractClass<ExamEnrolment, ExamEnrolmentDTO> {

    public ExamEnrolmentRestController() {

    }

    @Autowired
    public ExamEnrolmentRestController(ExamEnrolmentRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "grade",
                        "grade",
                        "points",
                        "points",
                        "student",
                        "courseEnrolment.student.userGeneralData.username"
                ),
                new ExamEnrolmentDTO(
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
    public ResponseEntity<ExamEnrolmentDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<ExamEnrolmentDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<ExamEnrolmentDTO> post(@RequestBody ExamEnrolmentDTO examEnrolmentDTO) {
        return super.post(examEnrolmentDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<ExamEnrolmentDTO> put(@RequestBody ExamEnrolmentDTO examEnrolmentDTO) {
        return super.put(examEnrolmentDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
