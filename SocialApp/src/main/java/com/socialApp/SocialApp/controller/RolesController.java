package com.socialApp.SocialApp.controller;


import com.socialApp.SocialApp.model.Role;
import com.socialApp.SocialApp.service.RoleService;
import com.socialApp.SocialApp.service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/roles")
public class RolesController {
    private RoleService roleService;

    @Autowired
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public Response findAll(){
        return roleService.findAll();
    }
    @PostMapping("")
    public Response save(@RequestBody Role role){
        return roleService.save(role);
    }
}
