package com.socialApp.SocialApp.service.impl;



import com.socialApp.SocialApp.dto.AssignRoleToUserDto;
import com.socialApp.SocialApp.dto.RegisterDto;
import com.socialApp.SocialApp.model.Role;
import com.socialApp.SocialApp.model.User;
import com.socialApp.SocialApp.repository.RoleRepository;
import com.socialApp.SocialApp.repository.UserRepository;
import com.socialApp.SocialApp.service.UserService;
import com.socialApp.SocialApp.service.response.Response;
import com.socialApp.SocialApp.service.response.SuccessDataResponse;
import com.socialApp.SocialApp.service.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private BCryptPasswordEncoder passEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passEncoder = passEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }


    @Override
    public Response save(RegisterDto registerDto) {
        User user=adjustDefaultUser(registerDto);
        userRepository.save(user);
        return new SuccessResponse();
    }

    @Override
    public Response delete(int id) { return new SuccessResponse();
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<User>>(true,"Users Listed",userRepository.findAll());
    }

    @Override
    public Response findById(int id) {
        return new SuccessDataResponse<Optional<User>>(true,"User Found",userRepository.findById(id));
    }

    @Override
    public Response assignRoleToUser(AssignRoleToUserDto assignRoleToUser) {
        User user=userRepository.findById(assignRoleToUser.getUser_id()).get();
        Role role=roleRepository.findById(assignRoleToUser.getRole_id()).get();
        user.getRoles().add(role);
        userRepository.save(user);
        return new SuccessResponse();
    }


    private User adjustDefaultUser(RegisterDto registerDto){
        User user=registerDto.registerDtoToUser(registerDto);
        Role defaultRole=roleRepository.findByName("USER");
        user.setRoles(new HashSet<>());
        user.getRoles().add(defaultRole);
        user.setPassword(user.getPassword());
        user.setDate(LocalDateTime.now());
        user.setEnabled(false);
        user.setPassword(passEncoder.encode(user.getPassword()));
        return user;
    }
}
