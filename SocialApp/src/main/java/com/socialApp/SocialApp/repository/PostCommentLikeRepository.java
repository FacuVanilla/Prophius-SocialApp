package com.socialApp.SocialApp.repository;


import com.socialApp.SocialApp.model.PostCommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentLikeRepository extends JpaRepository<PostCommentLike,Integer> {
}
