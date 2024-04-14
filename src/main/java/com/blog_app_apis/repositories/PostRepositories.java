package com.blog_app_apis.repositories;

import com.blog_app_apis.entities.Category;
import com.blog_app_apis.entities.Post;
import com.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepositories extends JpaRepository<Post, Integer> {

        List<Post> findByUser(User user);
        List<Post> findByCategory(Category category);
}
