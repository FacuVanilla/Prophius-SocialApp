package com.socialApp.SocialApp.service;


import com.socialApp.SocialApp.dto.AssignRoleToUserDto;
import com.socialApp.SocialApp.dto.RegisterDto;
import com.socialApp.SocialApp.service.response.Response;

public interface UserService {
    Response save(RegisterDto registerDto);
    Response delete(int id);
    Response findAll();
    Response findById(int id);
    Response assignRoleToUser(AssignRoleToUserDto assignRoleToUser);
}
