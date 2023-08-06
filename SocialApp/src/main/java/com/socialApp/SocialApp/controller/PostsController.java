package com.socialApp.SocialApp.controller;


import com.socialApp.SocialApp.dto.SavePostDto;
import com.socialApp.SocialApp.service.PostService;
import com.socialApp.SocialApp.service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/posts")
public class PostsController {
    private PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public Response findAll(){
        return postService.findAll();
    }
    @GetMapping("/{id}")
    public Response findById(@RequestParam int id){
        return postService.findById(id);
    }

    @PostMapping("")
    public Response save(@RequestBody SavePostDto savePostDto){
        return postService.save(savePostDto);
    }
}
