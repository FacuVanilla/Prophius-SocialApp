package com.socialApp.SocialApp.service.impl;


import com.socialApp.SocialApp.model.Role;
import com.socialApp.SocialApp.repository.RoleRepository;
import com.socialApp.SocialApp.service.RoleService;
import com.socialApp.SocialApp.service.response.Response;
import com.socialApp.SocialApp.service.response.SuccessDataResponse;
import com.socialApp.SocialApp.service.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Response save(Role role) {
        roleRepository.save(role);
        return new SuccessResponse();
    }

    @Override
    public Response update(Role role) {
        return null;
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<Role>>(true,"Roles Listed",roleRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
