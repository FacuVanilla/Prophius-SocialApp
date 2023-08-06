package com.socialApp.SocialApp.service;


import com.socialApp.SocialApp.dto.SavePostCommentDto;
import com.socialApp.SocialApp.model.PostComment;
import com.socialApp.SocialApp.service.response.Response;

public interface PostCommentService {
    Response save(SavePostCommentDto savePostCommentDto);
    Response delete(int id);
    Response update(PostComment comment);
    Response findAll();
    Response findById(int id);
    Response findByPostId(int id);
    int getPostCommentCount(int postId);
}
