package com.bookstore.service.impl;

import com.bookstore.domain.dto.RoleDto;
import com.bookstore.domain.dto.RoleRequest;
import com.bookstore.domain.entity.RoleEntity;
import com.bookstore.domain.mapper.RoleMapper;
import com.bookstore.repository.RoleRepository;
import com.bookstore.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto createRole(RoleRequest request) {
        RoleEntity roleEntity = RoleMapper.roleRequestToEntity(request);
        roleEntity = roleRepository.save(roleEntity);
        return RoleMapper.toDto(roleEntity);
    }

    @Override
    public RoleDto updateRole(Long id, RoleRequest request) {
        RoleEntity existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));

        existingRole.setName(request.getName());
        RoleEntity updatedRole = roleRepository.save(existingRole);
        return RoleMapper.toDto(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Role not found with id: " + id);
        }
    }

    @Override
    public RoleDto getRoleById(Long id) {
        RoleEntity roleEntity = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        return RoleMapper.toDto(roleEntity);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        return roleEntities.stream()
                .map(RoleMapper::toDto)
                .toList();
    }
}
