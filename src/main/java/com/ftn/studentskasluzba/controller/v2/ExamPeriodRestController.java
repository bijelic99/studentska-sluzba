package com.ftn.studentskasluzba.controller.v2;


import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.ExamPeriodDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.ExamPeriod;
import com.ftn.studentskasluzba.service.rest.ExamPeriodRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/exam-period")
public class ExamPeriodRestController extends RestControllerAbstractClass<ExamPeriod, ExamPeriodDTO> {

    public ExamPeriodRestController() {

    }

    @Autowired
    public ExamPeriodRestController(ExamPeriodRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "name",
                        "name",
                        "startTime",
                        "startTime",
                        "endTime",
                        "endTime"
                ),
                new ExamPeriodDTO(
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
    public ResponseEntity<ExamPeriodDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<ExamPeriodDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<ExamPeriodDTO> post(@RequestBody ExamPeriodDTO examPeriodDTO) {
        return super.post(examPeriodDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<ExamPeriodDTO> put(@RequestBody ExamPeriodDTO examPeriodDTO) {
        return super.put(examPeriodDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
