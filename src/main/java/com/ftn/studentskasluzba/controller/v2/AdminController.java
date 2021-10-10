package com.ftn.studentskasluzba.controller.v2;

import com.ftn.studentskasluzba.controller.RestControllerAbstractClass;
import com.ftn.studentskasluzba.dto.AdminDTO;
import com.ftn.studentskasluzba.dto.PagingWrapper;
import com.ftn.studentskasluzba.model.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v2/admin")
public class AdminController extends RestControllerAbstractClass<Admin, AdminDTO> {

    public AdminController() {
        super(
                Set.of("id", "email", "username", "firstName", "lastName"),
                new AdminDTO(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                )
        );
    }

    @Override
    public ResponseEntity<AdminDTO> get(Long id) {
        return super.get(id);
    }

    @Override
    public ResponseEntity<PagingWrapper<AdminDTO>> getAll(Boolean includeDeleted, Optional<Integer> page, Optional<Integer> pageSize, Optional<String> sortBy, Optional<String> sortOrder) {
        return super.getAll(includeDeleted, page, pageSize, sortBy, sortOrder);
    }

    @Override
    public ResponseEntity<AdminDTO> post(AdminDTO adminDTO) {
        return super.post(adminDTO);
    }

    @Override
    public ResponseEntity<AdminDTO> put(AdminDTO adminDTO) {
        return super.put(adminDTO);
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        return super.delete(id);
    }
}
