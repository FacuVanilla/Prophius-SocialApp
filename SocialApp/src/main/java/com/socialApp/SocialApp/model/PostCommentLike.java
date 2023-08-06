package com.socialApp.SocialApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "post_comment_likes")
public class PostCommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "comment_id")
    private PostComment comment;

  @ManyToOne()
  @JoinColumn(name = "user_id")
  private User user;
}
