package com.socialApp.SocialApp.service;


import com.socialApp.SocialApp.model.Role;
import com.socialApp.SocialApp.service.response.Response;

public interface RoleService {
    Response save(Role role);
    Response update(Role role);
    Response delete(int id);
    Response findAll();
    Response findById();
}
