package com.blog_app_apis.services;

import com.blog_app_apis.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser (UserDto user);
    UserDto updateUser (UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser();
    void deleteUserById(Integer userId);
}
