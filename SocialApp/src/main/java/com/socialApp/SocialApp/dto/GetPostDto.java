package com.socialApp.SocialApp.dto;


import com.socialApp.SocialApp.model.PostImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPostDto {


    private int id;
    private String postMessage;
    private List<PostImage> postImage;
    private String userName;
    private String firstName;
    private String lastName;
    private int likeCount;
    private int commentCount;




}
