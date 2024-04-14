package com.blog_app_apis.controller;


import com.blog_app_apis.payload.ApiResponce;
import com.blog_app_apis.payload.PostDto;
import com.blog_app_apis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {


    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //    createPost ("http://localhost:8080/api/user/{userId}/category/{categoryId}/posts")
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable("userId") Integer userId,
                                              @PathVariable("categoryId") Integer categoryId){
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }
//    updatePost
        @PutMapping("/post/postId")
        public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable Integer postId){
            PostDto postDto1 = this.postService.updatePost(postDto, postId);
            return new ResponseEntity<PostDto>(postDto1, HttpStatus.OK);
        }
//    getPostById
        @GetMapping("/post/postId")
        public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postById = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
        }
//    getAllPost
        @GetMapping("/allPost")
        public ResponseEntity<List<PostDto>> getAllPost(){
            List<PostDto> allPost = this.postService.getAllPost();
            return new ResponseEntity<List<PostDto>>(allPost, HttpStatus.OK);
        }
//    deletePost
        @DeleteMapping("/post/postId")
        public ResponseEntity<ApiResponce> deleteByPostId(@PathVariable Integer postId){
        this.postService.deleteById(postId);
        return new ResponseEntity<ApiResponce>(new ApiResponce("post is deleted successfully !!", true), HttpStatus.OK);
        }

//    getByCatagory ("http://localhost:8080/api/catagory/{catagoryId}/posts")
    @GetMapping("catagory/{catagoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCatagory(@PathVariable Integer catagoryId){
        List<PostDto> postByCategory = this.postService.getPostByCategory(catagoryId);

        return new ResponseEntity<List<PostDto>>(postByCategory, HttpStatus.OK);
    }
//    getByUser  ("http://localhost:8080/api/user/{userId}/posts")
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> postByUser = this.postService.getPostByUser(userId);

        return new ResponseEntity<List<PostDto>>(postByUser, HttpStatus.OK);
    }


}
