package com.charlesjackson.capstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesjackson.capstone.Entity.Category;
import com.charlesjackson.capstone.service.CategoryService;

@RestController
@RequestMapping("Category")
@CrossOrigin
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("add")
	public ResponseEntity<String> addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
		
	}
   @GetMapping("allCategory")
   public ResponseEntity<List<Category>> getAllCategory(){
	   return categoryService.getAllCategory();
	
   }
   @GetMapping("{Id}")
   public Optional<Category> getCategoryById(@PathVariable Integer Id) {
	return categoryService.getCategoryById(Id);
	   
   }
   @DeleteMapping("delete/{Id}")
   public String deleteCategoryById(@PathVariable Integer Id) {
	   return categoryService.deleteCategoryById(Id);
   }
}