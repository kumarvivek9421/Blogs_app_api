package com.blog_app_apis.services;

import com.blog_app_apis.payload.PostDto;

import java.util.List;

public interface PostService {

//    createPost
        PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
//    updatePost
        PostDto updatePost(PostDto postDto, Integer postId);
//    getPostById
        PostDto getPostById(Integer postId);
//    getAllPost
        List<PostDto> getAllPost();
//    deletePost
        void deleteById(Integer postId);
//    getPostByCategory
        List<PostDto> getPostByCategory(Integer categoryId);
//    getPostByUser
        List<PostDto> getPostByUser(Integer userId);
//    searchPost
        List<PostDto> searchPost(String keyword);
}
