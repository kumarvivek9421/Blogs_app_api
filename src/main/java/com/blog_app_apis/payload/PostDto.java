package com.blog_app_apis.payload;



import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {


    @NotBlank
    private String postTitle;
    @NotBlank
    private String postContent;
    private String imageName;
    private Data addedDate;
    private UserDto user;
    private CategoryDto category;
}
