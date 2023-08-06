package com.socialApp.SocialApp.service.impl;


import com.socialApp.SocialApp.model.PostImage;
import com.socialApp.SocialApp.repository.PostImageRepository;
import com.socialApp.SocialApp.service.PostImageService;
import com.socialApp.SocialApp.service.response.Response;
import com.socialApp.SocialApp.service.response.SuccessDataResponse;
import com.socialApp.SocialApp.service.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageServiceImpl implements PostImageService {
    private PostImageRepository postImageRepository;

    @Autowired
    public PostImageServiceImpl(PostImageRepository postImageRepository) {
        this.postImageRepository = postImageRepository;
    }


    @Override
    public Response save(PostImage image) {
        postImageRepository.save(image);
        return new SuccessResponse();
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response update(PostImage image) {
        return null;
    }

    @Override
    public Response findAll() {
        return new SuccessDataResponse<List<PostImage>>(true,"Images Listed",postImageRepository.findAll());
    }

    @Override
    public Response findById() {
        return null;
    }
}
