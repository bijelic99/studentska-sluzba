package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.EmployeeDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.Employee;
import com.ftn.studentskasluzba.service.rest.EmployeeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/employee")
public class EmployeeRestController extends RestControllerAbstractClass<Employee, EmployeeDTO> {

    public EmployeeRestController() {

    }

    @Autowired
    public EmployeeRestController(EmployeeRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "email",
                        "userGeneralData.email",
                        "username",
                        "userGeneralData.username",
                        "firstName",
                        "userGeneralData.firstName",
                        "lastName",
                        "userGeneralData.lastName"
                ),
                new EmployeeDTO(
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
    public ResponseEntity<EmployeeDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<EmployeeDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<EmployeeDTO> post(@RequestBody EmployeeDTO employeeDTO) {
        return super.post(employeeDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<EmployeeDTO> put(@RequestBody EmployeeDTO employeeDTO) {
        return super.put(employeeDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
