package com.bookstore.service;

import com.bookstore.domain.dto.RoleDto;
import com.bookstore.domain.dto.RoleRequest;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleRequest request);
    RoleDto updateRole(Long id, RoleRequest request);
    void deleteRole(Long id);
    RoleDto getRoleById(Long id);
    List<RoleDto> getAllRoles();
}
