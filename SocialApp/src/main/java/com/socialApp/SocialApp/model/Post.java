package com.socialApp.SocialApp.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "post_message")
    private String postMessage;



    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private  User user;

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages;
    @OneToMany(mappedBy = "post")
    private List<PostComment> postComments;


}
