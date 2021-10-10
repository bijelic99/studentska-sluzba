package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.AdminDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.Admin;
import com.ftn.studentskasluzba.service.rest.AdminRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/admin")
public class AdminRestController extends RestControllerAbstractClass<Admin, AdminDTO> {

    public AdminRestController() {

    }

    @Autowired
    public AdminRestController(AdminRestService service) {
        super(
                Map.of("id", "id", "email", "userGeneralData.email", "username", "userGeneralData.username", "firstName", "userGeneralData.firstName", "lastName", "userGeneralData.lastName"),
                new AdminDTO(
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
    public ResponseEntity<AdminDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<AdminDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<AdminDTO> post(@RequestBody AdminDTO adminDTO) {
        return super.post(adminDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<AdminDTO> put(@RequestBody AdminDTO adminDTO) {
        return super.put(adminDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
