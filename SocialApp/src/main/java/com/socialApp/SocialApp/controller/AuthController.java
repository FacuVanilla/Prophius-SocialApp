package com.socialApp.SocialApp.controller;

import com.socialApp.SocialApp.auth.TokenManager;
import com.socialApp.SocialApp.dto.AssignRoleToUserDto;
import com.socialApp.SocialApp.dto.LoginDto;
import com.socialApp.SocialApp.dto.RegisterDto;
import com.socialApp.SocialApp.repository.UserRepository;
import com.socialApp.SocialApp.service.UserService;
import com.socialApp.SocialApp.service.response.Response;
import com.socialApp.SocialApp.service.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private TokenManager tokenManager;


    @Autowired
    public AuthController(UserRepository userRepository, UserService userService, AuthenticationManager authenticationManager, TokenManager tokenManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final TokenResponse token = tokenManager.generateToken(authentication);
        return ResponseEntity.ok(token);

    }


    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(userService.save(registerDto));
    }
    @PostMapping("/assignrole")
    public Response assignRole(@RequestBody AssignRoleToUserDto assignRoleToUserDto){
        return userService.assignRoleToUser(assignRoleToUserDto);
    }

}
