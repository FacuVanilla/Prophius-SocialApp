package com.socialApp.SocialApp.service;


import com.socialApp.SocialApp.dto.SavePostDto;
import com.socialApp.SocialApp.model.Post;
import com.socialApp.SocialApp.service.response.Response;

public interface PostService {
    Response save(SavePostDto savePostDto);
    Response update(Post post);
    Response delete(int id);
    Response findAll();
    Response findById(int id);


}
