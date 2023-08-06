package com.socialApp.SocialApp.repository;


import com.socialApp.SocialApp.model.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage,Integer> {

}
