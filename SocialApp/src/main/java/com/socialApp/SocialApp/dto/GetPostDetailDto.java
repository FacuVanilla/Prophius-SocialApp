package com.socialApp.SocialApp.dto;

import com.socialApp.SocialApp.model.PostComment;
import com.socialApp.SocialApp.model.PostImage;
//import com.socialApp.SocialApp.model.PostLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetPostDetailDto {
    private int id;
    private List<PostComment> postComments;
    private LocalDateTime date;
    private String username;
    private List<PostImage> postImage;
}
