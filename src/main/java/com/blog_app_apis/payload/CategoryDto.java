package com.blog_app_apis.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Integer categoryId;
    @NotBlank
    @Size(min= 4, message = "min size of categoryTitle is 4")
    private String categoryTitle;
    @NotBlank
    @Size(min= 10, message = "min size of description is 10")
    private String categoryDescription;
}
