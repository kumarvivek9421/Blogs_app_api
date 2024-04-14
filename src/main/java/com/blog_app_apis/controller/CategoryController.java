package com.blog_app_apis.controller;

import com.blog_app_apis.payload.ApiResponce;
import com.blog_app_apis.payload.CategoryDto;
import com.blog_app_apis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apiCat")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //    create Category ("http://localhost:8080/apiCat/create")
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

//    update Category ("http://localhost:8080/apiCat/{catId}")
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId) {
    CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);
    return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
    }

//    getById Category ("http://localhost:8080/apiCat/{catId}")
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId) {
        CategoryDto categoryDto = this.categoryService.getCategoryById(catId);

        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

//    getAll Category ("http://localhost:8080/apiCat/allCat")
    @GetMapping("/allCat")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> allCategory = this.categoryService.getAllCategory();

        return ResponseEntity.ok(allCategory);
    }

//    delete Category ("http://localhost:8080/apiCat/{catId}")
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponce> deleteCategory(@PathVariable Integer catId) {
    this.categoryService.deleteById(catId);
    return new ResponseEntity<ApiResponce>(new ApiResponce("category is deleted successfully !!", true), HttpStatus.OK);
    }
}
