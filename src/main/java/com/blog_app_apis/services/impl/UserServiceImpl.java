package com.blog_app_apis.services.impl;

import com.blog_app_apis.entities.User;
import com.blog_app_apis.payload.UserDto;
import com.blog_app_apis.repositories.UserRepository;
import com.blog_app_apis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog_app_apis.exception.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user= this.dtoToUser(userDto);
        User saveUser= this.userRepo.save(user);
//        String randomId = UUID.randomUUID().toString();
//        userDto.setId(randomId);
        return this.userToDto(saveUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updateUser= this.userRepo.save(user);
        UserDto userDto1= this.userToDto(updateUser);

        return userDto1;
    }
    @Override
    public UserDto getUserById(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users= this.userRepo.findAll();
        List<UserDto> userDtos= users.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUserById(Integer userId) {

        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDto dto){
        User user= this.modelMapper.map(dto, User.class);
    //        ----- convert dtoToUser manual -----
//        User user= new User();
//        user.setId(dto.getId());
//        user.setName(dto.getName());
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
//        user.setAbout(dto.getAbout());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto dto= this.modelMapper.map(user, UserDto.class);
    //        ----- convert dtoToUser manual -----
//        UserDto dto= new UserDto();
//        dto.setId(user.getId());
//        dto.setName(user.getName());
//        dto.setEmail(user.getEmail());
//        dto.setPassword(user.getPassword());
//        dto.setAbout(user.getAbout());
        return dto;
    }
}
