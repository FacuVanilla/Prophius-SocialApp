package com.socialApp.SocialApp.service;


import com.socialApp.SocialApp.model.PostImage;
import com.socialApp.SocialApp.service.response.Response;

public interface PostImageService {
    Response save(PostImage image);
    Response delete(int id);
    Response update(PostImage image);
    Response findAll();
    Response findById();
}
