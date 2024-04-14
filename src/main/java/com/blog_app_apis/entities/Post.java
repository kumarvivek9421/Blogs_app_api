package com.blog_app_apis.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "post_title", length = 100, nullable = false)
    private String postTitle;
    @Column(name = "post_content", length = 100, nullable = false)
    private String postContent;
    private String imageName;
    private Date addedDate;

    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
