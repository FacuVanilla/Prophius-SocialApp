package com.socialApp.SocialApp.controller;


import com.socialApp.SocialApp.dto.SaveCommentLikeDto;
import com.socialApp.SocialApp.service.PostCommentLikeService;
import com.socialApp.SocialApp.service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/postcommentlikes")
public class PostCommentLikesController {
    private PostCommentLikeService postCommentLikeService;

    @Autowired
    public PostCommentLikesController(PostCommentLikeService postCommentLikeService) {
        this.postCommentLikeService = postCommentLikeService;
    }
    @GetMapping(name = "")
    public Response findAll(){
        return postCommentLikeService.findAll();
    }
    @PostMapping(name = "")
    public Response save(@RequestBody SaveCommentLikeDto commentLikeDto){
        return postCommentLikeService.save(commentLikeDto);
    }
}
