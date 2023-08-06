package com.socialApp.SocialApp.service;


import com.socialApp.SocialApp.dto.SaveCommentLikeDto;
import com.socialApp.SocialApp.service.response.Response;

public interface PostCommentLikeService {
    Response save(SaveCommentLikeDto saveCommentLikeDto);
    Response delete(int id);
    Response findAll();
    Response findById();
}
