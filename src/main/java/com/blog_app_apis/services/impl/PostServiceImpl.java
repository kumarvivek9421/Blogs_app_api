package com.blog_app_apis.services.impl;

import com.blog_app_apis.entities.Category;
import com.blog_app_apis.entities.Post;
import com.blog_app_apis.entities.User;
import com.blog_app_apis.exception.ResourceNotFoundException;
import com.blog_app_apis.payload.PostDto;
import com.blog_app_apis.repositories.CategoryRepositories;
import com.blog_app_apis.repositories.PostRepositories;
import com.blog_app_apis.repositories.UserRepository;
import com.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepositories postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CategoryRepositories categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        Category category= this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Post post= this.modelMapper.map(postDto, Post.class);

        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        post.setPostTitle(post.getPostTitle());
        post.setPostContent(post.getPostContent());
        post.setImageName(post.getImageName());

        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPost = this.postRepo.findAll();
        List<PostDto> collectPost = allPost.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return collectPost;
    }

    @Override
    public void deleteById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category= this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("catagory", "Id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(category);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user", "Id", userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }



}
