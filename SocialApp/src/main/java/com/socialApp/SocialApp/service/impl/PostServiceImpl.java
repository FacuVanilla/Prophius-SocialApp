package com.socialApp.SocialApp.service.impl;

import com.socialApp.SocialApp.dto.GetPostDetailDto;
import com.socialApp.SocialApp.dto.GetPostDto;
import com.socialApp.SocialApp.dto.SavePostDto;
import com.socialApp.SocialApp.model.Post;
import com.socialApp.SocialApp.repository.PostRepository;
import com.socialApp.SocialApp.service.PostCommentService;
import com.socialApp.SocialApp.service.PostService;
import com.socialApp.SocialApp.service.response.Response;
import com.socialApp.SocialApp.service.response.SuccessDataResponse;
import com.socialApp.SocialApp.service.response.SuccessResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;
    private PostCommentService postCommentService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, PostCommentService postCommentService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.postCommentService = postCommentService;
    }


    @Override
    public Response save(SavePostDto savePostDto) {
        Post post= savePostDto.savePostDtoToPost(savePostDto);
        postRepository.save(post);
        return new SuccessResponse();
    }

    @Override
    public Response update(Post post) {
        return null;
    }

    @Override
    public Response delete(int id) {
        return null;
    }

    @Override
    public Response findAll() {
        List<Post> posts=postRepository.findAll();
        List<GetPostDto> postDtos=getAsPostDto(posts);
        List<GetPostDto> postDtoswithLikeAndCommentCount=setPostLikeCountAndCommentCount(postDtos);
        return new SuccessDataResponse<List<GetPostDto>>(true,"Posts Listed",postDtoswithLikeAndCommentCount);
    }

    @Override
    public Response findById(int id) {
        Post post=postRepository.getById(id);
        GetPostDetailDto postDto=postToGetPostDto(post);
        return new SuccessDataResponse<GetPostDetailDto>(true,"Post byId",postDto);
    }

    private GetPostDetailDto postToGetPostDto(Post post){
        GetPostDetailDto postDto=modelMapper.map(post,GetPostDetailDto.class);
        return  postDto;
    }

    private List<GetPostDto> getAsPostDto(List<Post> posts){;
        GetPostDto postDtoFor=new GetPostDto();
        List<GetPostDto> postDtos1=posts.stream()
                .map(post -> modelMapper.map(post, GetPostDto.class))
                .collect(Collectors.toList());

                return postDtos1;

    }

    private List<GetPostDto> setPostLikeCountAndCommentCount(List<GetPostDto> getPostDtos){
       List<GetPostDto> result=getPostDtos.stream().map(getPostDto -> {
            getPostDto.setCommentCount(postCommentService.getPostCommentCount(getPostDto.getId()));
            return getPostDto;
        }).collect(Collectors.toList());
        return result;
    }

}
