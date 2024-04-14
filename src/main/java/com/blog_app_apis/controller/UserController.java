package com.blog_app_apis.controller;

import com.blog_app_apis.entities.User;
import com.blog_app_apis.payload.ApiResponce;
import com.blog_app_apis.payload.UserDto;
import com.blog_app_apis.repositories.UserRepository;
import com.blog_app_apis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    POST- Create User ("http://localhost:8080/api/users")
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto= this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

//    PUT- Update User ("http://localhost:8080/api/1")
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
                                              @PathVariable("userId") Integer userId){
        UserDto updateUser= this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }

//    GET Single- Get Single User ("http://localhost:8080/api/1")
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Integer userId){
//        UserDto userById = this.userService.getUserById(userId);
        Optional<User> user = userRepo.findById(userId);
        if(!user.isEmpty()) {
            Optional<String> userName = Optional.ofNullable(user.get().getName());
            return new ResponseEntity<>(userName.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Sorry User with given id is not present: ", HttpStatus.NOT_FOUND);
        }
    }

    //    GET All- Get All User ("http://localhost:8080/api/allUser")
    @GetMapping("/allUser")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> allUsers = this.userService.getAllUser();
//        List<String> allUsers = userService.getAllUser().stream().map(user -> user.getUserName())
//                .sorted().collect(Collectors.toList());
//        List<String> names = allUsers.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
//        String names = collect.stream().map(n -> n.toUpperCase()).collect(Collectors.joining(". "));
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

//    DELETE- Delete User ("http://localhost:8080/api/1")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponce> deleteUserById(@PathVariable("userId") Integer userId){
        this.userService.deleteUserById(userId);
        return new ResponseEntity<ApiResponce> (new ApiResponce("user deleted successfully...", true), HttpStatus.OK);
    }

}
