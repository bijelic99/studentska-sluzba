package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.ExamDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.Exam;
import com.ftn.studentskasluzba.service.rest.ExamRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/exam")
public class ExamRestController extends RestControllerAbstractClass<Exam, ExamDTO> {

    public ExamRestController() {

    }

    @Autowired
    public ExamRestController(ExamRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "examDateTime",
                        "examDateTime",
                        "examEnrolmentFee",
                        "examEnrolmentFee",
                        "course",
                        "course.subject.title",
                        "examPeriod",
                        "examPeriod.name"
                ),
                new ExamDTO(
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
    public ResponseEntity<ExamDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<ExamDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<ExamDTO> post(@RequestBody ExamDTO examDTO) {
        return super.post(examDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<ExamDTO> put(@RequestBody ExamDTO examDTO) {
        return super.put(examDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

}
