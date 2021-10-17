package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.dto.TeachingRoleDTO;
import com.ftn.studentskasluzba.model.TeachingRole;
import com.ftn.studentskasluzba.service.rest.TeachingRoleRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/teaching-role")
public class TeachingRoleRestController extends RestControllerAbstractClass<TeachingRole, TeachingRoleDTO> {

    public TeachingRoleRestController() {

    }

    @Autowired
    public TeachingRoleRestController(TeachingRoleRestService service) {
        super(
                Map.of(
                        "id",
                        "id",
                        "name",
                        "name"
                ),
                new TeachingRoleDTO(
                        null,
                        null,
                        null
                ),
                service
        );
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<TeachingRoleDTO> get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<PagingWrapper<TeachingRoleDTO>> getAll(@RequestParam(name = "includeDeleted", defaultValue = "false") Boolean includeDeleted, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy, @RequestParam Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @PostMapping
    @Override
    public ResponseEntity<TeachingRoleDTO> post(@RequestBody TeachingRoleDTO teachingRoleDTO) {
        return super.post(teachingRoleDTO);
    }

    @PutMapping
    @Override
    public ResponseEntity<TeachingRoleDTO> put(@RequestBody TeachingRoleDTO teachingRoleDTO) {
        return super.put(teachingRoleDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
