package com.socialApp.SocialApp.service.impl;


import com.socialApp.SocialApp.dto.SaveCommentLikeDto;
import com.socialApp.SocialApp.model.PostCommentLike;
import com.socialApp.SocialApp.repository.PostCommentLikeRepository;
import com.socialApp.SocialApp.service.PostCommentLikeService;
import com.socialApp.SocialApp.service.response.Response;
import com.socialApp.SocialApp.service.response.SuccessDataResponse;
import com.socialApp.SocialApp.service.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentLikeServiceImpl implements PostCommentLikeService {
    private PostCommentLikeRepository postCommentLikeRepository;


    @Autowired
    public PostCommentLikeServiceImpl(PostCommentLikeRepository postCommentLikeRepository) {
        this.postCommentLikeRepository = postCommentLikeRepository;
    }


    @Override
    public Response save(SaveCommentLikeDto saveCommentLikeDto) {
        PostCommentLike postCommentLike=saveCommentLikeDto.saveCommentLikeDtoToPostCommentLike(saveCommentLikeDto);
         postCommentLikeRepository.save(postCommentLike);
         return new SuccessResponse();
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<PostCommentLike>>(true,"Listed Comment Like",postCommentLikeRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
