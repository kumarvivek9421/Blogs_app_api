package com.blog_app_apis.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private int id;
    @NotNull
    @Size(min = 4, message = "username must be min of 4 character !!")
//    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$", message = "username must be of 6 to 12 lenght with no special character !!")
    private String name;
    @Email(message = "email id is not valid !!")
    private String email;
    @NotEmpty
    @Size(min= 3, max= 10, message = "password must be of 4 to 20 character !!")
//    @Pattern(regexp = "^(?=.*[!@#$&*])[a-zA-Z0-9]{4,15}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit !!")
    private String password;
    @NotEmpty
    private String about;
}





//    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
//            message = "username must be of 6 to 12 length with no special characters")
//    private String username;
//
//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",
//            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
//    private String password;
//
//    @Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Flag.UNICODE_CASE)
