package com.socialApp.SocialApp.dto;

import com.socialApp.SocialApp.model.PostComment;
import com.socialApp.SocialApp.model.PostCommentLike;
import com.socialApp.SocialApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveCommentLikeDto {
    private int user_id;
    private int comment_id;


    public PostCommentLike saveCommentLikeDtoToPostCommentLike(SaveCommentLikeDto saveCommentLikeDto){
        PostCommentLike commentLike=new PostCommentLike();
        PostComment comment=new PostComment();
        User user=new User();
        user.setId(saveCommentLikeDto.getUser_id());
        comment.setId(saveCommentLikeDto.getComment_id());
        commentLike.setComment(comment);
        commentLike.setUser(user);
        return commentLike;
    }
}
